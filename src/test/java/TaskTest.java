import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import chatbot.task.Task;

    class TaskTest {

        @Test
        void taskMarker_inputTask_taskMarkedAsDone() {
            Task task = new Task("Read a book");
            assertEquals(" " ,  task.getStatusIcon());

            task.markAsDone();
            assertEquals("X", task.getStatusIcon());
        }
    }
