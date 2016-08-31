package com.dci.intellij.dbn.code.common.style.presets.statement;

import com.dci.intellij.dbn.language.common.psi.BasePsiElement;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.Wrap;
import com.intellij.psi.codeStyle.CodeStyleSettings;

public class StatementOneLineSpacingPreset extends StatementAbstractPreset {
    public StatementOneLineSpacingPreset() {
        super("one_line", "One line");
    }

    public Wrap getWrap(BasePsiElement psiElement, CodeStyleSettings settings) {
        return null;
    }

    public Spacing getSpacing(BasePsiElement psiElement, CodeStyleSettings settings) {
        return SPACING_ONE_LINE;
    }
}