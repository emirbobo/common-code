package com.dci.intellij.dbn.codegenerator.options;

import com.dci.intellij.dbn.codegenerator.options.ui.ChooseTablesForm;
import com.dci.intellij.dbn.common.ui.dialog.DBNDialog;
import com.dci.intellij.dbn.common.ui.list.CheckBoxList;
import com.dci.intellij.dbn.common.ui.list.Selectable;
import com.dci.intellij.dbn.connection.ConnectionBundle;
import com.dci.intellij.dbn.connection.ConnectionHandler;
import com.dci.intellij.dbn.connection.ConnectionManager;
import com.dci.intellij.dbn.editor.data.state.column.ui.ColumnStateSelectable;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ChooseTablesDialog extends DBNDialog<ChooseTablesForm> {

    String dbName;
    JTextField jTextField;
    List<String> tables;
    public ChooseTablesDialog(Project project,@NotNull String dbName,JTextField jTextField) {
        super(project, "choose tables" , true);
        this.dbName = dbName;
        this.jTextField = jTextField;
        initDB();
        component = new ChooseTablesForm(this,tables);
        getOKAction().putValue(Action.NAME, "OK" );
        init();
    }

    private void initDB(){
        tables = Lists.newArrayList();
        ConnectionManager connectionManager = ConnectionManager.getInstance(getProject());
        final ConnectionBundle connectionBundle = connectionManager.getConnectionBundle();
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement= null;
        if (connectionBundle.getConnectionHandlers().size() > 0) {
            for (ConnectionHandler connectionHandler : connectionBundle.getConnectionHandlers()) {

                if(dbName.trim().equals(connectionHandler.getName())){
                    try {
                        connection = connectionHandler.getStandaloneConnection();
                        preparedStatement = connection.prepareStatement("show tables");
                        rs = preparedStatement.executeQuery();
                        while(rs!=null && rs.next()){
                            tables.add(rs.getString(1));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            if(rs!=null){
                                rs.close();
                            }
                            if(preparedStatement != null){
                                preparedStatement.close();
                            }
                            if(connection!= null){
                                connection.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }


    }


    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @NotNull
    protected final Action[] createActions() {
        return new Action[]{
            getOKAction(),
            getCancelAction()
        };
    }

    @Override
    protected void doOKAction() {

        List<String> selectedTables = Lists.newArrayList();
        ListModel model = component.getTableCheckBoxList().getModel();
        for(int i=0; i<model.getSize(); i++ ) {
            if(component.getTableCheckBoxList().getElementAt(i).isSelected()) {
                selectedTables.add(component.getTableCheckBoxList().getElementAt(i).getName());
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<selectedTables.size();i++){
            if(i> 0){
                sb.append(",");
            }
            sb.append(selectedTables.get(i));
        }
        jTextField.setText(sb.toString());

        super.doOKAction();
    }

    @NotNull
    public Action getOKAction() {
        return super.getOKAction();
    }


    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent() {
        return component.getTableCheckBoxList();
    }
}
