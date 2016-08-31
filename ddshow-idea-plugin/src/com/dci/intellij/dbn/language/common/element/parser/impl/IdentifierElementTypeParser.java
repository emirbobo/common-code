package com.dci.intellij.dbn.language.common.element.parser.impl;

import org.jetbrains.annotations.NotNull;

import com.dci.intellij.dbn.language.common.ParseException;
import com.dci.intellij.dbn.language.common.TokenType;
import com.dci.intellij.dbn.language.common.element.IdentifierElementType;
import com.dci.intellij.dbn.language.common.element.parser.AbstractElementTypeParser;
import com.dci.intellij.dbn.language.common.element.parser.ParseResult;
import com.dci.intellij.dbn.language.common.element.parser.ParseResultType;
import com.dci.intellij.dbn.language.common.element.parser.ParserBuilder;
import com.dci.intellij.dbn.language.common.element.parser.ParserContext;
import com.dci.intellij.dbn.language.common.element.path.ParsePathNode;
import com.intellij.lang.PsiBuilder;

public class IdentifierElementTypeParser extends AbstractElementTypeParser<IdentifierElementType> {
    public IdentifierElementTypeParser(IdentifierElementType elementType) {
        super(elementType);
    }

    public ParseResult parse(@NotNull ParsePathNode parentNode, boolean optional, int depth, ParserContext context) throws ParseException {
        ParserBuilder builder = context.getBuilder();
        logBegin(builder, optional, depth);
        TokenType tokenType = builder.getTokenType();
        if (tokenType != null && !tokenType.isChameleon()){
            if (tokenType.isIdentifier()) {
                PsiBuilder.Marker marker = builder.mark(null);
                builder.advanceLexer(parentNode);
                return stepOut(marker, null, context, depth, ParseResultType.FULL_MATCH, 1);
            }
            else if (isSuppressibleReservedWord(parentNode, context, tokenType)) {
                PsiBuilder.Marker marker = builder.mark(null);
                builder.advanceLexer(parentNode);
                return stepOut(marker, null, context, depth, ParseResultType.FULL_MATCH, 1);
            }
        }
        return stepOut(null, null, context, depth, ParseResultType.NO_MATCH, 0);
    }

    private boolean isSuppressibleReservedWord(ParsePathNode parentNode, ParserContext context, TokenType tokenType) {
        if (tokenType.isSuppressibleReservedWord()) {
            if (context.isWavedTokenType(tokenType)) {
                return true;
            }

            return (getElementType().isDefinition() && !getElementType().isAlias()) || isSuppressibleReservedWord(tokenType, parentNode, context);
        }
        return false;
    }
}