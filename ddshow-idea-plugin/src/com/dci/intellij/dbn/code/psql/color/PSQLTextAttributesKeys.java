package com.dci.intellij.dbn.code.psql.color;

import com.intellij.codeInsight.template.impl.TemplateColors;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public interface PSQLTextAttributesKeys {
    TextAttributesKey LINE_COMMENT       = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.LineComment",       DefaultLanguageHighlighterColors.LINE_COMMENT);
    TextAttributesKey BLOCK_COMMENT      = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.BlockComment",      DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    TextAttributesKey STRING             = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.String",            DefaultLanguageHighlighterColors.STRING);
    TextAttributesKey NUMBER             = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Number",            DefaultLanguageHighlighterColors.NUMBER);
    TextAttributesKey DATA_TYPE          = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.DataType",          DefaultLanguageHighlighterColors.CONSTANT);
    TextAttributesKey ALIAS              = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Alias",             DefaultLanguageHighlighterColors.IDENTIFIER);
    TextAttributesKey IDENTIFIER         = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Identifier",        DefaultLanguageHighlighterColors.IDENTIFIER);
    TextAttributesKey QUOTED_IDENTIFIER  = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.QuotedIdentifier",  DefaultLanguageHighlighterColors.IDENTIFIER);
    TextAttributesKey KEYWORD            = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Keyword",           DefaultLanguageHighlighterColors.KEYWORD);
    TextAttributesKey FUNCTION           = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Function",          DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
    TextAttributesKey PARAMETER          = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Parameter",         TemplateColors.TEMPLATE_VARIABLE_ATTRIBUTES);
    TextAttributesKey EXCEPTION          = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Exception",         DefaultLanguageHighlighterColors.KEYWORD);
    TextAttributesKey OPERATOR           = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Operator",          DefaultLanguageHighlighterColors.OPERATION_SIGN);
    TextAttributesKey PARENTHESIS        = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Parenthesis",       DefaultLanguageHighlighterColors.PARENTHESES);
    TextAttributesKey BRACKET            = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.Brackets",          DefaultLanguageHighlighterColors.BRACKETS);
    TextAttributesKey UNKNOWN_IDENTIFIER = TextAttributesKey.createTextAttributesKey("DBNavigator.TextAttributes.PSQL.UnknownIdentifier", CodeInsightColors.WRONG_REFERENCES_ATTRIBUTES);
    TextAttributesKey BAD_CHARACTER      = HighlighterColors.BAD_CHARACTER;
}
