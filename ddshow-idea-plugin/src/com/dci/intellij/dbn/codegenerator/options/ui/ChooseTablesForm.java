package com.dci.intellij.dbn.codegenerator.options.ui;

import com.dci.intellij.dbn.codegenerator.options.ChooseTableEntry;
import com.dci.intellij.dbn.codegenerator.options.ChooseTablesDialog;
import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.common.ui.DBNFormImpl;
import com.dci.intellij.dbn.common.ui.DBNHeaderForm;
import com.dci.intellij.dbn.common.ui.list.CheckBoxList;
import com.dci.intellij.dbn.common.util.NamingUtil;
import com.dci.intellij.dbn.common.util.StringUtil;
import com.dci.intellij.dbn.connection.ConnectionHandler;
import com.dci.intellij.dbn.connection.console.ui.CreateRenameConsoleDialog;
import com.dci.intellij.dbn.vfs.DBConsoleVirtualFile;
import com.google.common.collect.Lists;
import com.intellij.ui.DocumentAdapter;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Set;

public class ChooseTablesForm extends DBNFormImpl<ChooseTablesDialog>{
//    private JPanel headerPanel;
    private JPanel mainPanel;
//    private JTextField consoleNameTextField;
    private JLabel errorLabel;
    private JScrollPane tablesPanel;
    private CheckBoxList tableCheckBoxList;
    private List<ChooseTableEntry> tableList;
//    private ConnectionHandler connectionHandler;
//    private DBConsoleVirtualFile console;

    public CheckBoxList getTableCheckBoxList() {
        return tableCheckBoxList;
    }

    public ChooseTablesForm(final ChooseTablesDialog parentComponent,List<String> tables/*, @NotNull ConnectionHandler connectionHandler, @Nullable final DBConsoleVirtualFile console*/) {
        super(parentComponent);
//        this.connectionHandler = connectionHandler;
//        this.console = console;
        tableCheckBoxList = new CheckBoxList(buildTableEntry(tables),true);
        tablesPanel.setViewportView(tableCheckBoxList);
        errorLabel.setForeground(JBColor.RED);
        errorLabel.setIcon(Icons.EXEC_MESSAGES_ERROR);
        errorLabel.setVisible(false);

//        DBNHeaderForm headerForm = new DBNHeaderForm(connectionHandler);
//        headerPanel.add(headerForm.getComponent(), BorderLayout.CENTER);

//        final Set<String> consoleNames = connectionHandler.getConsoleBundle().getConsoleNames();

//        String name;
//        if (console == null) {
//            name = connectionHandler.getName() + " 1";
//            while (consoleNames.contains(name)) {
//                name = NamingUtil.getNextNumberedName(name, true);
//            }
//        } else {
//            name = console.getName();
//            consoleNames.remove(name);
//            parentComponent.getOKAction().setEnabled(false);
//        }
//        consoleNameTextField.setText(name);

//        consoleNameTextField.getDocument().addDocumentListener(new DocumentAdapter() {
//            @Override
//            protected void textChanged(DocumentEvent e) {
//                String errorText = null;
//                String text = StringUtil.trim(consoleNameTextField.getText());
//
//                if (StringUtil.isEmpty(text)) {
//                    errorText = "Console name must be specified";
//                }
//                else if (consoleNames.contains(text)) {
//                    errorText = "Console name already in use";
//                }
//
//
//                errorLabel.setVisible(errorText != null);
//                parentComponent.getOKAction().setEnabled(errorText == null && (console == null || !console.getName().equals(text)));
//                if (errorText != null) {
//                    errorLabel.setText(errorText);
//                }
//            }
//        });
    }

    private List<ChooseTableEntry> buildTableEntry(List<String> tables){
        if(tableList == null){
            tableList = Lists.newArrayList();
        }
        for(String tableName: tables){
            tableList.add(new ChooseTableEntry(tableName));
        }
        return tableList;
    }

//    public JTextField getConsoleNameTextField() {
//        return consoleNameTextField;
//    }
//
//    public String getConsoleName() {
//        return consoleNameTextField.getText();
//    }

//    public ConnectionHandler getConnectionHandler() {
//        return connectionHandler;
//    }

//    public DBConsoleVirtualFile getConsole() {
//        return console;
//    }

    @Override
    public JComponent getComponent() {
        return mainPanel;
    }
}
