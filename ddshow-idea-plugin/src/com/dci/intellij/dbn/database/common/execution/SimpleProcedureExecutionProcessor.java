package com.dci.intellij.dbn.database.common.execution;

import com.dci.intellij.dbn.execution.method.MethodExecutionInput;
import com.dci.intellij.dbn.object.DBProcedure;

public class SimpleProcedureExecutionProcessor extends MethodExecutionProcessorImpl<DBProcedure> {
    public SimpleProcedureExecutionProcessor(DBProcedure procedure) {
        super(procedure);
    }

    @Override
    public String buildExecutionCommand(MethodExecutionInput executionInput) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("{call ");
        buffer.append(getMethod().getQualifiedName());
        buffer.append("(");
        for (int i=0; i< getArgumentsCount(); i++) {
            if (i>0) buffer.append(",");
            buffer.append("?");
        }
        buffer.append(")}");
        return buffer.toString();
    }

}
