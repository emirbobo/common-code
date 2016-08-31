package com.dci.intellij.dbn.code.common.style.formatting;

import org.jdom.Element;

import com.dci.intellij.dbn.common.util.CommonUtil;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.Wrap;

public class FormattingDefinition {
    public static final FormattingDefinition LINE_BREAK_BEFORE = new FormattingDefinition(null, null, SpacingDefinition.MIN_LINE_BREAK, null);
    public static final FormattingDefinition LINE_BREAK_AFTER = new FormattingDefinition(null, null, null, SpacingDefinition.MIN_LINE_BREAK);

    public static final FormattingDefinition ONE_SPACE_BEFORE = new FormattingDefinition(null, null, SpacingDefinition.ONE_SPACE, null);
    public static final FormattingDefinition NO_SPACE_BEFORE = new FormattingDefinition(null, null, SpacingDefinition.NO_SPACE, null);

    private WrapDefinition wrap;
    private IndentDefinition indent;
    private SpacingDefinition spacingBefore;
    private SpacingDefinition spacingAfter;
    private FormattingAttributes attributes;

    public FormattingDefinition(){
    }

    public FormattingDefinition(WrapDefinition wrap, IndentDefinition indent, SpacingDefinition spacingBefore, SpacingDefinition spacingAfter) {
        this.wrap = wrap;
        this.indent = indent;
        this.spacingBefore = spacingBefore;
        this.spacingAfter = spacingAfter;
    }

    protected FormattingDefinition(FormattingDefinition attributes) {
        indent = attributes.indent;
        wrap = attributes.wrap;
        spacingBefore = attributes.spacingBefore;
        spacingAfter = attributes.spacingAfter;
    }

    protected FormattingDefinition(Element def) {
        indent = IndentDefinition.get(def);
        wrap = WrapDefinition.get(def);
        spacingBefore = SpacingDefinition.get(def, true);
        spacingAfter = SpacingDefinition.get(def, false);
    }

    public void merge(FormattingDefinition defaults) {
        wrap = CommonUtil.nvln(wrap, defaults.wrap);
        indent = CommonUtil.nvln(indent, defaults.indent);
        spacingBefore = CommonUtil.nvln(spacingBefore, defaults.spacingBefore);
        spacingAfter = CommonUtil.nvln(spacingAfter, defaults.spacingAfter);
    }
    
    public FormattingAttributes getAttributes() {
        if (attributes == null) {
            Wrap wrap = this.wrap == null ? null : this.wrap.getValue();
            Indent indent = this.indent == null ? null : this.indent.getValue();
            Spacing spacingBefore = this.spacingBefore == null ? null : this.spacingBefore.getValue();
            Spacing spacingAfter = this.spacingAfter == null ? null : this.spacingAfter.getValue();
            attributes = new FormattingAttributes(wrap, indent, spacingBefore, spacingAfter);
        }
        return attributes;
    }

    public boolean isEmpty() {
        return  wrap == null &&
                indent == null &&
                spacingBefore == null &&
                spacingAfter == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("");
        if (wrap != null) result.append("wrap=").append(wrap).append(' ');
        if (indent != null) result.append("indent=").append(indent).append(' ');
        if (spacingBefore != null) result.append("spacingBefore=").append(spacingBefore).append(' ');
        if (spacingAfter != null) result.append("spacingAfter=").append(spacingAfter).append(' ');

        return result.toString();
    }
}

