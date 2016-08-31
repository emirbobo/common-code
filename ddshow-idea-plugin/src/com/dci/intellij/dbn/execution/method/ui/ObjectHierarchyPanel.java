package com.dci.intellij.dbn.execution.method.ui;

import com.dci.intellij.dbn.common.Icons;
import com.dci.intellij.dbn.object.common.DBObject;
import com.intellij.ui.RowIcon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectHierarchyPanel extends JPanel {
    private DBObject object;

    public ObjectHierarchyPanel(DBObject object) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Color color = new Color(255, 255, 239);
        setBackground(color);
        Border border = new CompoundBorder(
                new LineBorder(Color.GRAY, 1, false),
                new LineBorder(color, 4, false));
        setBorder(border);
        this.object = object;

        List<DBObject> chain = new ArrayList<DBObject>();
        while (object != null) {
            chain.add(0, object);
            object = object.getParentObject();
        }
        for (int i=0; i<chain.size(); i++) {
            object = chain.get(i);
            RowIcon icon = new RowIcon(i+1);
            icon.setIcon(object.getIcon(), i);
            if (i > 0) icon.setIcon(Icons.TREE_BRANCH, i-1);
            if (i > 1) {
                for (int j=0; j<i-1; j++) {
                    icon.setIcon(Icons.SPACE, j);
                }
            }
            JLabel label = new JLabel(object.getName(), icon, SwingConstants.LEFT);
            
            if (object == this.object) {
                Font font = label.getFont().deriveFont(Font.BOLD);
                label.setFont(font);
            } else {

            }
            add(label);
        }
    }
}
