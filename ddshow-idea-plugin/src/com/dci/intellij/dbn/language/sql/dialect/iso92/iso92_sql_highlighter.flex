package com.dci.intellij.dbn.language.sql.dialect.iso92;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.dci.intellij.dbn.language.sql.SQLLanguage;
import com.dci.intellij.dbn.language.common.TokenTypeBundle;

%%

%class Iso92SQLHighlighterFlexLexer
%implements FlexLexer
%public
%pack
%final
%unicode
%ignorecase
%function advance
%type IElementType
%eof{ return;
%eof}


%{
    private int braceCounter = 0;
    private TokenTypeBundle tt;
    public Iso92SQLHighlighterFlexLexer(TokenTypeBundle tt) {
        this.tt = tt;
    }
%}

WHITE_SPACE= {white_space_char}|{line_terminator}
line_terminator = \r|\n|\r\n
input_character = [^\r\n]
white_space = [ \t\f]
white_space_char= [ \n\r\t\f]
ws  = {WHITE_SPACE}+
wso = {WHITE_SPACE}*

comment_tail =([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
BLOCK_COMMENT=("/*"[^]{comment_tail})|"/*"
LINE_COMMENT = "--" {input_character}*

IDENTIFIER = [:jletter:] [:jletterdigit:]*
QUOTED_IDENTIFIER = "`"[^\`]*"`"?

CHARSET ="armscii8"|"ascii"|"big5"|"binary"|"cp1250"|"cp1251"|"cp1256"|"cp1257"|"cp850"|"cp852"|"cp866"|"cp932"|"dec8"|"eucjpms"|"euckr"|"gb2312"|"gbk"|"geostd8"|"greek"|"hebrew"|"hp8"|"keybcs2"|"koi8r"|"koi8u"|"latin1"|"latin2"|"latin5"|"latin7"|"macce"|"macroman"|"sjis"|"swe7"|"tis620"|"ucs2"|"ujis"|"utf8"

string_simple_quoted      = "'"([^\']|"''"|{WHITE_SPACE})*"'"?
STRING = ("n"|"_"{CHARSET})?{wso}{string_simple_quoted}

sign = "+"|"-"
digit = [0-9]
INTEGER = {digit}+("e"{sign}?{digit}+)?
NUMBER = {INTEGER}?"."{digit}+(("e"{sign}?{digit}+)|(("f"|"d"){ws}))?

VARIABLE = ":"{wso}({IDENTIFIER}|{INTEGER})

operator_equals             = "="
operator_not_equals         = (("!"|"^"|"�"){wso}"=")|("<"{wso}">")
operator_greater_than       = ">"
operator_greater_equal_than = ">"{wso}"="
operator_less_than          = "<"
operator_less_equal_than    = ">"{wso}"="
OPERATOR                    = {operator_equals}|{operator_not_equals}|{operator_greater_than}|{operator_greater_equal_than}|{operator_less_than}|{operator_less_equal_than}


KEYWORD   = "accessible"|"add"|"all"|"alter"|"analyze"|"and"|"as"|"asc"|"asensitive"|"before"|"between"|"both"|"by"|"call"|"cascade"|"case"|"change"|"character"|"check"|"close"|"collate"|"column"|"columns"|"concurrent"|"condition"|"constraint"|"continue"|"convert"|"create"|"cross"|"current_user"|"cursor"|"data"|"database"|"databases"|"declare"|"default"|"delayed"|"delete"|"desc"|"describe"|"deterministic"|"distinct"|"distinctrow"|"div"|"do"|"drop"|"dual"|"dumpfile"|"duplicate"|"each"|"else"|"elseif"|"enclosed"|"end"|"escaped"|"exists"|"exit"|"expansion"|"explain"|"fetch"|"fields"|"first"|"float4"|"float8"|"for"|"force"|"foreign"|"from"|"fulltext"|"grant"|"group"|"handler"|"having"|"high_priority"|"if"|"ignore"|"in"|"index"|"infile"|"inner"|"inout"|"insensitive"|"insert"|"int1"|"int2"|"int3"|"int4"|"int8"|"interval"|"into"|"is"|"iterate"|"join"|"key"|"keys"|"kill"|"language"|"last"|"leading"|"leave"|"left"|"level"|"like"|"limit"|"linear"|"lines"|"load"|"local"|"lock"|"long"|"loop"|"low_ignore"|"low_priority"|"master_ssl_verify_server_cert"|"match"|"microsecond"|"middleint"|"mod"|"mode"|"modifies"|"natural"|"next"|"no_write_to_binlog"|"not"|"null"|"offset"|"oj"|"on"|"open"|"optimize"|"option"|"optionally"|"or"|"order"|"out"|"outer"|"outfile"|"precision"|"prev"|"primary"|"procedure"|"purge"|"query"|"quick"|"range"|"read"|"read_only"|"read_write"|"reads"|"references"|"regexp"|"release"|"rename"|"repeat"|"replace"|"require"|"restrict"|"return"|"reverse"|"revoke"|"right"|"rlike"|"rollup"|"schema"|"schemas"|"select"|"sensitive"|"separator"|"set"|"share"|"show"|"spatial"|"specific"|"sql"|"sql_big_result"|"sql_buffer_result"|"sql_cache"|"sql_calc_found_rows"|"sql_no_cache"|"sql_small_result"|"sqlexception"|"sqlstate"|"sqlwarning"|"ssl"|"starting"|"straight_join"|"table"|"terminated"|"then"|"to"|"trailing"|"trigger"|"truncate"|"undo"|"union"|"unique"|"unlock"|"unsigned"|"update"|"usage"|"use"|"using"|"value"|"values"|"varcharacter"|"varying"|"when"|"where"|"while"|"with"|"write"|"xor"|"zerofill"|"false"|"true"
FUNCTION  = "abs"|"acos"|"adddate"|"addtime"|"aes_decrypt"|"aes_encrypt"|"against"|"ascii"|"asin"|"atan"|"atan2"|"avg"|"benchmark"|"bin"|"bit_and"|"bit_length"|"bit_or"|"bit_xor"|"boolean"|"ceil"|"ceiling"|"char"|"char_length"|"character_length"|"charset"|"coercibility"|"collation"|"compress"|"concat"|"concat_ws"|"connection_id"|"conv"|"convert_tz"|"cos"|"cot"|"count"|"crc32"|"curdate"|"current_date"|"current_time"|"current_timestamp"|"current_user"|"curtime"|"database"|"date"|"date_add"|"date_format"|"date_sub"|"datediff"|"day"|"day_hour"|"day_microsecond"|"day_minute"|"day_second"|"dayname"|"dayofmonth"|"dayofweek"|"dayofyear"|"decode"|"default"|"degrees"|"des_decrypt"|"des_encrypt"|"elt"|"encode"|"encrypt"|"exp"|"expansion"|"export_set"|"extract"|"field"|"find_in_set"|"floor"|"fn_second_microsecond"|"format"|"found_rows"|"from_days"|"from_unixtime"|"get_format"|"get_lock"|"group_concat"|"hex"|"hour"|"hour_microsecond"|"hour_minute"|"hour_second"|"if"|"ifnull"|"inet_aton"|"inet_ntoa"|"insert"|"instr"|"is_free_lock"|"is_used_lock"|"language"|"last_day"|"last_insert_id"|"lcase"|"left"|"length"|"like"|"ln"|"load_file"|"localtime"|"localtimestamp"|"locate"|"log"|"log10"|"log2"|"lower"|"lpad"|"ltrim"|"make_set"|"makedate"|"maketime"|"master_pos_wait"|"match"|"max"|"md5"|"microsecond"|"mid"|"min"|"minute"|"minute_microsecond"|"minute_second"|"mod"|"month"|"monthname"|"name_const"|"not_like"|"not_regexp"|"now"|"nullif"|"oct"|"octet_length"|"old_password"|"ord"|"password"|"period_add"|"period_diff"|"pi"|"position"|"pow"|"power"|"quarter"|"query"|"quote"|"radians"|"rand"|"regexp"|"release_lock"|"repeat"|"replace"|"reverse"|"right"|"rlike"|"round"|"row_count"|"rpad"|"rtrim"|"schema"|"sec_to_time"|"second"|"second_microsecond"|"session_user"|"sha"|"sha1"|"sha2"|"sign"|"sin"|"sleep"|"soundex"|"sounds_like"|"space"|"sqrt"|"std"|"stddev"|"stddev_pop"|"stddev_samp"|"str_to_date"|"strcmp"|"subdate"|"substr"|"substring"|"substring_index"|"subtime"|"sum"|"sysdate"|"system_user"|"tan"|"time"|"time_format"|"time_to_sec"|"timediff"|"timestamp"|"timestampadd"|"timestampdiff"|"to_days"|"trim"|"truncate"|"ucase"|"uncompress"|"uncompressed_length"|"unhex"|"unix_timestamp"|"upper"|"user"|"utc_date"|"utc_time"|"utc_timestamp"|"uuid"|"uuid_short"|"values"|"var_pop"|"var_samp"|"variance"|"version"|"week"|"weekday"|"weekofyear"|"weight_string"|"year"|"year_month"|"yearweek"
DATA_TYPE = "bit"|"tinyint"|"bool"|"boolean"|"smallint"|"mediumint"|"int"|"integer"|"bigint"|"double"{ws}"precision"|"double"|"real"|"float"|"decimal"|"dec"|"numeric"|"fixed"|"date"|"datetime"|"timestamp"|"time"|"year"|"varchar"|"national"{ws}"varchar"|"binary"|"varbinary"|"tinyblob"|"tinytext"|"blob"|"text"|"mediumblob"|"mediumtext"|"longblob"|"longtext"|"enum"

%state DIV
%%

{VARIABLE}   { return tt.getTokenType("VARIABLE"); }

{WHITE_SPACE}+   { return tt.getSharedTokenTypes().getWhiteSpace(); }

{BLOCK_COMMENT}      { return tt.getSharedTokenTypes().getBlockComment(); }
{LINE_COMMENT}       { return tt.getSharedTokenTypes().getLineComment(); }

{INTEGER}     { return tt.getTokenType("INTEGER"); }
{NUMBER}      { return tt.getTokenType("NUMBER"); }
{STRING}      { return tt.getTokenType("STRING"); }

{FUNCTION}             { yybegin(YYINITIAL); return tt.getTokenType("FUNCTION");}
//{PARAMETER}            { yybegin(YYINITIAL); return tt.getTokenType("PARAMETER");}

{DATA_TYPE}            { yybegin(YYINITIAL); return tt.getTokenType("DATA_TYPE"); }
{KEYWORD}              { yybegin(YYINITIAL); return tt.getTokenType("KEYWORD"); }
{OPERATOR}             { yybegin(YYINITIAL); return tt.getTokenType("OPERATOR"); }


{IDENTIFIER}           { yybegin(YYINITIAL); return tt.getSharedTokenTypes().getIdentifier(); }
{QUOTED_IDENTIFIER}    { yybegin(YYINITIAL); return tt.getSharedTokenTypes().getQuotedIdentifier(); }


"("                    { return tt.getTokenType("CHR_LEFT_PARENTHESIS"); }
")"                    { return tt.getTokenType("CHR_RIGHT_PARENTHESIS"); }
"["                    { return tt.getTokenType("CHR_LEFT_BRACKET"); }
"]"                    { return tt.getTokenType("CHR_RIGHT_BRACKET"); }

<YYINITIAL> {
    .                  { yybegin(YYINITIAL); return tt.getSharedTokenTypes().getIdentifier(); }
}
