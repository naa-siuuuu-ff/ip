# User Guide to Ozil: How to use the World's best assist machine

## Features ##

1. Add todo, deadline and event tasks to Ozil.
2. List all tasks that have been added in current and previous sessions. 
3. Mark or unmark tasks as completed, and delete tasks.
4. See latest deadlines and events in order
5. Find tasks by their description

## Quick Start ##
1. Ensure you have Java 17 installed in your Computer.\
Mac users need to ensure they have the precise JDK version prescribed [here](https://github.com/se-edu/addressbook-level3/releases).
2. Download the ```.jar``` file.
3. Open a command terminal, ```cd``` into the folder your jar file is in, and use ```java -jar ozil-chatbot.jar```
to run the application.
4. The opening page should look like this.
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 5.29.44 PM.png)

 5. Here are the commands you can run:\
- **`todo <description>`** – Creates a todo task
- **`deadline <description> /by <YYYY-MM-DD HHmm>`** – Creates a deadline task (time is optional)
- **`event <description> /from <YYYY-MM-DD HHmm> /to <HHmm>`** – Creates an event task
- **`list`** – Lists all tasks
- **`find <task description keywords>`**- Finds tasks with matching description
- **`latest`** – Lists all tasks with proper datetimes in chronological order
- **`mark <tasknumber>`** – Marks a task as complete
- **`unmark <tasknumber>`** – Unmarks a task
- **`delete <tasknumber>`** – Deletes the task
- **`bye`** – Exits the club with Ozil


## Adding todo tasks
Adds a basic todo task with no dates attached\
Format: **`todo <description>`**
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 5.58.01 PM.png)

## Adding events
Adds an event with a start date and time, and an end time\
Format:  **`event <description> /from <YYYY-MM-DD HHmm> /to <HHmm>`**\

Example: **`event Team meeting /from 2025-09-23 1400 /to 1500`**\
Adds a team meeting event that starts at 23 Sept 2pm and ends at 3pm on the same day.\
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 5.57.08 PM.png)


## Adding deadlines 
Adds a deadline with a deadline date time.\
Format: **`deadline <description> /by <YYYY-MM-DD HHmm>`**\
Example: **`deadline Submit report /by 2025-09-24 1800`**
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 5.59.18 PM.png)


## Listing all tasks
Lists all tasks.\
Format:**`list`**
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 6.00.08 PM.png)

## Marking and unmarking tasks as complete/incomplete, and deleting tasks
Mark or unmark a task as complete or incomplete respectively, or delete tasks.
Format: **`mark <tasknumber>`**, **`unmark <tasknumber>`** or  **`delete <tasknumber>`**\
Example: **`mark 2`**, **`unmark 2`**, and **`delete 2`**
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 6.06.47 PM.png)


## Find task
Find tasks based on their description.\
Format: **`find <task description keywords>`**
Example: **`find chapter`**`
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 6.11.51 PM.png)

## Get latest tasks in chronological order
Get all tasks that have properly added dates in chronological order\
Format: **`latest`**
![](/Users/nasif/Documents/Screenshots/Screenshot 2025-09-22 at 6.15.56 PM.png)
