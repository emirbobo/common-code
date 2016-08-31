package com.dci.intellij.dbn.language.common.parameter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.dci.intellij.dbn.language.common.element.ElementType;
import com.dci.intellij.dbn.language.common.element.IterationElementType;
import com.dci.intellij.dbn.language.common.element.TokenElementType;
import com.dci.intellij.dbn.language.common.element.WrapperElementType;
import com.dci.intellij.dbn.language.common.element.util.ElementTypeAttribute;
import com.dci.intellij.dbn.language.common.psi.BasePsiElement;
import com.dci.intellij.dbn.language.common.psi.PsiUtil;
import com.dci.intellij.dbn.language.common.psi.lookup.ObjectReferenceLookupAdapter;
import com.dci.intellij.dbn.object.common.DBObjectType;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.parameterInfo.CreateParameterInfoContext;
import com.intellij.lang.parameterInfo.ParameterInfoContext;
import com.intellij.lang.parameterInfo.ParameterInfoHandler;
import com.intellij.lang.parameterInfo.ParameterInfoUIContext;
import com.intellij.lang.parameterInfo.UpdateParameterInfoContext;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;

public class ColumnParameterInfoHandler implements ParameterInfoHandler<BasePsiElement, BasePsiElement> {
    public static final ObjectReferenceLookupAdapter METHOD_LOOKUP_ADAPTER = new ObjectReferenceLookupAdapter(null, DBObjectType.METHOD, null);
    public static final ObjectReferenceLookupAdapter ARGUMENT_LOOKUP_ADAPTER = new ObjectReferenceLookupAdapter(null, DBObjectType.ARGUMENT, null);

    @Override
    public boolean couldShowInLookup() {
        return true;
    }

    @Nullable
    @Override
    public Object[] getParametersForLookup(LookupElement item, ParameterInfoContext context) {
        return null;
    }

    @Nullable
    @Override
    public Object[] getParametersForDocumentation(BasePsiElement method, ParameterInfoContext context) {
        return null;
    }

    @Nullable
    @Override
    public BasePsiElement findElementForParameterInfo(@NotNull CreateParameterInfoContext context) {
        BasePsiElement handlerPsiElement = lookupHandlerElement(context.getFile(), context.getOffset());
        BasePsiElement providerPsiElement = lookupProviderElement(handlerPsiElement);
        if (handlerPsiElement != null && providerPsiElement != null) {
            context.setItemsToShow(new Object[]{providerPsiElement});

            int offset = context.getOffset();
            BasePsiElement iterationPsiElement = handlerPsiElement.findFirstPsiElement(IterationElementType.class);
            if (iterationPsiElement != null) {
                IterationElementType iterationElementType = (IterationElementType) iterationPsiElement.getElementType();
                PsiElement paramPsiElement = iterationPsiElement.getFirstChild();
                BasePsiElement iteratedPsiElement = null;
                while (paramPsiElement != null) {
                    ElementType elementType = PsiUtil.getElementType(paramPsiElement);
                    if (elementType instanceof TokenElementType) {
                        TokenElementType tokenElementType = (TokenElementType) elementType;
                        if (iterationElementType.isSeparator(tokenElementType.getTokenType())){
                            if (paramPsiElement.getTextOffset() >= offset) {
                                break;
                            }
                        }
                    }
                    if (elementType == iterationElementType.getIteratedElementType()) {
                        iteratedPsiElement = (BasePsiElement) paramPsiElement;
                    }

                    paramPsiElement = paramPsiElement.getNextSibling();
                }
                return iteratedPsiElement;
            } else {
                return handlerPsiElement;
            }
        }
        return providerPsiElement;
    }


    @Nullable
    public static BasePsiElement lookupHandlerElement(PsiFile file, int offset) {
        PsiElement psiElement = file.findElementAt(offset);
        while (psiElement != null) {
            if (psiElement instanceof BasePsiElement) {
                ElementType elementType = PsiUtil.getElementType(psiElement);
                if (elementType instanceof WrapperElementType) {
                    WrapperElementType wrapperElementType = (WrapperElementType) elementType;
                    if (wrapperElementType.is(ElementTypeAttribute.COLUMN_PARAMETER_HANDLER)) {
                        return (BasePsiElement) psiElement;
                    } else {
                        return null;
                    }
                }
            }
            psiElement = psiElement.getParent();
        }
        return null;
    }

    @Nullable
    public static BasePsiElement lookupProviderElement(@Nullable BasePsiElement handlerPsiElement) {
        if (handlerPsiElement != null) {
            BasePsiElement statementPsiElement = handlerPsiElement.findEnclosingPsiElement(ElementTypeAttribute.STATEMENT);
            if (statementPsiElement != null) {
                return statementPsiElement.findFirstPsiElement(ElementTypeAttribute.COLUMN_PARAMETER_PROVIDER);
            }
        }
        return null;
    }

    @Override
    public void showParameterInfo(@NotNull BasePsiElement element, @NotNull CreateParameterInfoContext context) {
        context.showHint(element, context.getOffset(), this);
    }

    @Nullable
    @Override
    public BasePsiElement findElementForUpdatingParameterInfo(@NotNull UpdateParameterInfoContext context) {
        int offset = context.getOffset();
        BasePsiElement handlerPsiElement = lookupHandlerElement(context.getFile(), offset);
        if (handlerPsiElement != null) {
            BasePsiElement iterationPsiElement = handlerPsiElement.findFirstPsiElement(IterationElementType.class);
            if (iterationPsiElement != null) {
                IterationElementType iterationElementType = (IterationElementType) iterationPsiElement.getElementType();
                PsiElement paramPsiElement = iterationPsiElement.getFirstChild();
                BasePsiElement iteratedPsiElement = null;
                while (paramPsiElement != null) {
                    ElementType elementType = PsiUtil.getElementType(paramPsiElement);
                    if (elementType instanceof TokenElementType) {
                        TokenElementType tokenElementType = (TokenElementType) elementType;
                        if (iterationElementType.isSeparator(tokenElementType.getTokenType())){
                            if (paramPsiElement.getTextOffset() >= offset) {
                                break;
                            }
                        }
                    } else if (paramPsiElement instanceof BasePsiElement) {
                        iteratedPsiElement = (BasePsiElement) paramPsiElement;
                    }

                    paramPsiElement = paramPsiElement.getNextSibling();
                }
                return iteratedPsiElement == null ? handlerPsiElement : iteratedPsiElement;
            } else {
                return handlerPsiElement;
            }


        }
        return null;
    }

    @Override
    public void updateParameterInfo(@NotNull BasePsiElement parameter, @NotNull UpdateParameterInfoContext context) {
        BasePsiElement wrappedPsiElement = getWrappedPsiElement(context);
        if (wrappedPsiElement != null) {
            IterationElementType iterationElementType = (IterationElementType) wrappedPsiElement.getElementType();
            int index = 0;
            PsiElement paramPsiElement = wrappedPsiElement.getFirstChild();
            while (paramPsiElement != null) {
                ElementType elementType = PsiUtil.getElementType(paramPsiElement);
                if (elementType == iterationElementType.getIteratedElementType()) {
                    if (paramPsiElement == parameter) {
                        context.setCurrentParameter(index);
                        return;
                    }
                    index++;
                }
                paramPsiElement = paramPsiElement.getNextSibling();
            }
            context.setCurrentParameter(index);
        }
    }

    public static BasePsiElement getWrappedPsiElement(UpdateParameterInfoContext context) {
        BasePsiElement basePsiElement = lookupHandlerElement(context.getFile(), context.getOffset());
        if (basePsiElement != null) {
            return basePsiElement.findFirstPsiElement(IterationElementType.class);
        }
        return null;
    }

    @Nullable
    @Override
    public String getParameterCloseChars() {
        return ",";
    }

    @Override
    public boolean tracksParameterIndex() {
        return false;
    }

    @Override
    public void updateUI(BasePsiElement handlerPsiElement, @NotNull ParameterInfoUIContext context) {
        context.setUIComponentEnabled(true);
        StringBuilder text = new StringBuilder();
        int highlightStartOffset = 0;
        int highlightEndOffset = 0;
        int index = 0;
        int currentIndex = context.getCurrentParameterIndex();
        BasePsiElement iterationPsiElement = handlerPsiElement.findFirstPsiElement(IterationElementType.class);
        if (iterationPsiElement != null) {
            IterationElementType iterationElementType = (IterationElementType) iterationPsiElement.getElementType();
            PsiElement child = iterationPsiElement.getFirstChild();
            while (child != null) {
                if (child instanceof BasePsiElement) {
                    BasePsiElement basePsiElement = (BasePsiElement) child;
                    if (basePsiElement.getElementType()  == iterationElementType.getIteratedElementType()) {
                        boolean highlight = index == currentIndex || (index == 0 && currentIndex == -1);
                        if (highlight) {
                            highlightStartOffset = text.length();
                        }
                        if (text.length() > 0) {
                            text.append(", ");
                        }
                        text.append(basePsiElement.getText());
                        //text.append(" ");
                        //text.append(argument.getDataType().getQualifiedName());
                        if (highlight) {
                            highlightEndOffset = text.length();
                        }
                        index++;
                    }
                }

                child = child.getNextSibling();
            }
        }



/*        for (DBArgument argument : providerPsiElement.getArguments()) {
            if (argument != providerPsiElement.getReturnArgument()) {
                boolean highlight = index == currentIndex || (index == 0 && currentIndex == -1);
                if (highlight) {
                    highlightStartOffset = text.length();
                }
                if (text.length() > 0) {
                    text.append(", ");
                }
                text.append(argument.getName().toLowerCase());
                //text.append(" ");
                //text.append(argument.getDataType().getQualifiedName());
                if (highlight) {
                    highlightEndOffset = text.length();
                }
                index++;
            }
        }*/
        boolean disable = highlightEndOffset == 0 && currentIndex > -1 && text.length() > 0;
        if (text.length() == 0) {
            text.append("<no parameters>");
        }
        context.setupUIComponentPresentation(text.toString(), highlightStartOffset, highlightEndOffset, disable, false, false, context.getDefaultParameterColor());
    }
}
