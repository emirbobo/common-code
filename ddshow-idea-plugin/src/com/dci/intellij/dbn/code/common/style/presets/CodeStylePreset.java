package com.dci.intellij.dbn.code.common.style.presets;

import com.dci.intellij.dbn.common.ui.Presentable;
import com.dci.intellij.dbn.language.common.psi.BasePsiElement;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.WrapType;
import com.intellij.psi.codeStyle.CodeStyleSettings;

public interface CodeStylePreset extends Presentable{
    Wrap WRAP_NONE = Wrap.createWrap(WrapType.NONE, false);
    Wrap WRAP_NORMAL = Wrap.createWrap(WrapType.NORMAL, true);
    Wrap WRAP_ALWAYS = Wrap.createWrap(WrapType.ALWAYS, true);
    Wrap WRAP_IF_LONG = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, true);

    Spacing SPACING_NO_SPACE = Spacing.createSpacing(0, 0, 0, false, 0);
    Spacing SPACING_ONE_SPACE = Spacing.createSpacing(1, 1, 0, false, 0);

    Spacing SPACING_LINE_BREAK = Spacing.createSpacing(0, Integer.MAX_VALUE, 1, true, 0);
    Spacing SPACING_MIN_LINE_BREAK = Spacing.createSpacing(0, Integer.MAX_VALUE, 1, true, 4);

    Spacing SPACING_ONE_LINE = Spacing.createSpacing(0, Integer.MAX_VALUE, 2, true, 1);
    Spacing SPACING_MIN_ONE_LINE = Spacing.createSpacing(0, Integer.MAX_VALUE, 2, true, 4);
    Spacing SPACING_MIN_ONE_SPACE = Spacing.createSpacing(1, Integer.MAX_VALUE, 0, true, 4);


    String getId();
    boolean accepts(BasePsiElement psiElement);
    Wrap getWrap(BasePsiElement psiElement, CodeStyleSettings settings);
    Spacing getSpacing(BasePsiElement psiElement, CodeStyleSettings settings);
}
