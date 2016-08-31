package com.dci.intellij.dbn.database.postgres.execution;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dci.intellij.dbn.data.type.DBDataType;
import com.dci.intellij.dbn.database.common.execution.MethodExecutionProcessorImpl;
import com.dci.intellij.dbn.execution.method.MethodExecutionInput;
import com.dci.intellij.dbn.execution.method.result.MethodExecutionResult;
import com.dci.intellij.dbn.object.DBArgument;
import com.dci.intellij.dbn.object.DBMethod;

public class PostgresMethodExecutionProcessor extends MethodExecutionProcessorImpl<DBMethod> {
    private Boolean isQuery;

    public PostgresMethodExecutionProcessor(DBMethod method) {
        super(method);
    }

    @Override
    public String buildExecutionCommand(MethodExecutionInput executionInput) throws SQLException {
        StringBuilder buffer = new StringBuilder();
        if (isQuery()) {
            buffer.append("select * from ");
            buffer.append(getMethod().getQualifiedName());
            buffer.append("(");
            for (int i=1; i< getArgumentsCount(); i++) {
                if (i>1) buffer.append(",");
                buffer.append("?");
            }
            buffer.append(")");

        } else {
            buffer.append("{ ? = call ");
            buffer.append(getMethod().getQualifiedName());
            buffer.append("(");
            for (int i=1; i< getArgumentsCount(); i++) {
                if (i>1) buffer.append(",");
                buffer.append("?");
            }
            buffer.append(")}");
        }

        return buffer.toString();
    }

    @Override
    protected void bindParameters(MethodExecutionInput executionInput, PreparedStatement preparedStatement) throws SQLException {
        if (isQuery()) {
            List<DBArgument> arguments = getArguments();
            for (int i = 1; i < arguments.size(); i++) {
                DBArgument argument = arguments.get(i);
                DBDataType dataType = argument.getDataType();
                if (argument.isInput()) {
                    String stringValue = executionInput.getInputValue(argument);
                    setParameterValue(preparedStatement, argument.getPosition()-1, dataType, stringValue);
                } else if (argument.isOutput()) {
                    setParameterValue(preparedStatement, argument.getPosition()-1, dataType, "1");
                }
            }

        } else {
            super.bindParameters(executionInput, preparedStatement);
        }
    }

    @Override
    public void loadValues(MethodExecutionResult executionResult, PreparedStatement preparedStatement) throws SQLException {
        if (isQuery()) {
            DBArgument returnArgument = getReturnArgument();
            executionResult.addArgumentValue(returnArgument, preparedStatement.getResultSet());
        } else {
            super.loadValues(executionResult, preparedStatement);
        }
    }

    protected boolean isQuery() {
        if (isQuery == null) {
            DBMethod method = getMethod();
            DBArgument returnArgument = method == null ? null : method.getReturnArgument();
            isQuery = returnArgument != null && returnArgument.getDataType().isSet() && !hasOutputArguments();
        }
        return isQuery;
    }

    private boolean hasOutputArguments() {
        List<DBArgument> arguments = getArguments();
        for (int i=1; i< arguments.size(); i++) {
            if (arguments.get(i).isOutput() && !arguments.get(i).isInput()) {
                return true;
            }
        }
        return false;
    }
}