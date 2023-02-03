package timeBoxing;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TimeBoxGUI {
    JFrame frame;
    JTextField descriptionField;
    JTextField importanceField;
    JTextField timeNeededField;
    LList<Task> taskList = new LList<Task>();
    
    public TimeBoxGUI() {
        frame = new JFrame("Task Manager");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 3));

        // add Task Description label and the insert box
        panel.add(new JLabel("Task Description"));
        descriptionField = new JTextField();
        panel.add(descriptionField);

        // add Task Importance label and the insert box
        panel.add(new JLabel("Task Importance (1-10)"));
        importanceField = new JTextField();
        panel.add(importanceField);

        // add Time Needed label and the insert box
        panel.add(new JLabel("Time Needed (hours)"));
        timeNeededField = new JTextField();
        panel.add(timeNeededField);

        // add task list display label and the text area
        panel.add(new JLabel("Task List"));
        JTextArea taskListDisplay = new JTextArea();
        panel.add(taskListDisplay);

        // add task button
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
                updateTaskListDisplay(taskListDisplay);
            }
        });
        
        // add task button
        JButton resetList = new JButton("Reset List");
        resetList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetList();
                updateTaskListDisplay(taskListDisplay);
            }
        });

        // sort tasks by list button
        JButton sortListTime = new JButton("Sort tasks by time");
        sortListTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortListTime();
                updateTaskListDisplay(taskListDisplay);
            }
        });

        // sort tasks by list button
        JButton sortListImportance = new JButton("Sort tasks by Importance");
        sortListImportance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortListImportance();
                updateTaskListDisplay(taskListDisplay);
            }
        });

        panel.add(addButton);
        panel.add(resetList);
        panel.add(sortListTime);
        panel.add(sortListImportance);

        frame.add(panel, BorderLayout.CENTER);

        
        frame.setVisible(true);
    }
    
    /**
     * 
     */
    private void addTask() {
        String description = descriptionField.getText();
        int importance = Integer.parseInt(importanceField.getText());
        double timeNeeded = Double.parseDouble(timeNeededField.getText());
        
        Task task = new Task(description, importance, timeNeeded);
        taskList.add(task);
        importanceField.setText("");
        descriptionField.setText("");
        timeNeededField.setText("");
        
    }
    
    private void resetList() {
        taskList.clear();
    }
    
    /**
     * 
     */
    private void sortListTime() {
        SelectionSort.sortByTime(taskList);
    }
    
    /**
     * 
     */
    private void sortListImportance() {
        SelectionSort.sortByImportance(taskList);
    }
    
    /**
     * 
     * @param taskListDisplay
     */
    private void updateTaskListDisplay(JTextArea taskListDisplay) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            sb.append(String.format("Task %d: %s, Importance: %d, Time Needed: %.1f hours\n", i + 1, task.getDescription(), task.getImportance(), task.getTimeNeeded()));
        }
        taskListDisplay.setText(sb.toString());
    }

    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        new TimeBoxGUI();
    }
}
