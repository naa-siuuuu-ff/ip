package ozil.main;

import ozil.exception.ErrorMessages;
import ozil.exception.OzilException;
import ozil.task.DeadlineTask;
import ozil.task.EventTask;
import ozil.task.Task;
import ozil.task.TodoTask;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<? extends Task> loadStoredTasks() throws OzilException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                return tasks;
            }

            // create a Scanner using the File as the source
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String fileInput = s.nextLine();
                String[] sections = fileInput.split(" \\| ");

                Task task;
                switch (sections[0]) {
                case "T":
                    task = new TodoTask(sections[2]);
                    break;
                case "D":
                    task = new DeadlineTask(sections[2], sections[3]);
                    break;
                case "E":
                    task = new EventTask(sections[2], sections[3], sections[4]);
                    break;
                default:
                    throw new OzilException(ErrorMessages.errorMessage("Unexpected type of task was" +
                            " found during file parsing"));
                }

                if (Integer.parseInt(sections[1]) == 1) {
                    task.markAsDone();
                }

                tasks.add(task);
            }

            } catch(FileNotFoundException e){
                throw new OzilException(ErrorMessages.errorMessage("An error occurred while saving: " +
                        e));
            }

            return tasks;
    }

        public void save(ArrayList < Task > taskList) throws OzilException {
            try {
                File file = new File(this.filePath);
                file.getParentFile().mkdirs();
                FileWriter fileWriter = new FileWriter(file);
                for (Task task : taskList) {
                    fileWriter.append(task.convertToStorageFormat());
                    fileWriter.append("\n");
                }
                fileWriter.close();
            } catch (IOException e) {
                throw new OzilException(ErrorMessages.errorMessage("An error occurred while saving: " +
                        e));
            }
        }
    }