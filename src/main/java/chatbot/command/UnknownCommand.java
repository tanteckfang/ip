package chatbot.command;

import chatbot.Ui;
import chatbot.ChatbotException;
import chatbot.task.TaskManager;

public class UnknownCommand extends Command{
    private String userInput;

    public UnknownCommand (String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskManager taskManager, Ui ui) throws ChatbotException {
        if ("list".equalsIgnoreCase(userInput)) {
            taskManager.printTasks();
        } else if (userInput.startsWith("delete")) {
            int index = Integer.parseInt(userInput.split(" ")[1]);
            taskManager.deleteTask(index);
        } else if (userInput.startsWith("task on")) {
            String date = userInput.split(" ")[2];  // Changed from 1 to 2
            taskManager.printTasksOnDate(date);
        } else if (userInput.startsWith("find")) {
           String keyword = userInput.split(" ")[1];
           taskManager.findTaskByKeyboard(keyword);
        }
        else {
            throw new ChatbotException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

}
