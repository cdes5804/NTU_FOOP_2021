# Design Report
> Please follow the instructions in homework 3 (officially announced version on NTU COOL) to finish the report.

## Software Design

**Main**: Entry point of the program. Launch filesystem and CLI.

### CLI

**CLI**: The CLI that the user interacts with. Responsible for reading, parsing and executing user commands and communicate with the underlying filesystem.

### FileSystem
*Includes elements that make up the filesystem*

**FileSystem**: Represents the whole filesystem, which is a tree. Includes the root node of the filesystem and a member function that retrieves a node when given a path to that node.

**Node**: The basic unit that makes the filesystem. Includes some common members and functions that a node will use.

**File**: A special node representing a file. Inherits **Node** and overrides some functions in **Node** to meet the requirements of a file.

**Directory**: A special node representing a directory. Inherits **Node** and ovrrides some functions in **Node** to meet the requirements of a directory.

**Link**: A special node representing a soft link, which links to another directory. Inherits **Node** and overrides some functions in **Node** to meet the requirements of a link.

### Commands
*Includes commands that a user can use. They may interact with the filesystem or CLI*

**Command**: The abstract class meant to be inherited by all commands.

**Cat**: Implementation of the `cat` command. Fetches the data stored in a node and prints it. Reports error when the no data available.

**ChangeDirectory**: Implementation of the `cd` command. Use the function provided by the filesystem to get the destination node(directory) and update the current directory in CLI.

**Exit**: Implementation of the `exit` command. Tells the CLI to exit.

**Listing**: Implementation of the `ls` command. Enumerates the children of a node and prints their names.

**MakeDirectory**: Implementation of the `mkdir` command. Adds a new **Directory** node as a child of the current node.

**Remove**: Implementation of the `rm` command. Removes the node with the specified name from the current node's children.

**Search**: Implementation of the `search` command. Performs pre-order traversal on the current subtree to search.

**SoftLink**: Implementation of the `ln` command. Adds a **Link** node that links to a **Directory** node in the filesystem as a child of the current node by using the function provided by the filesystem.

**Touch**: Implementation of the `touch` command. Adds a **File** node as a child of the current node.
