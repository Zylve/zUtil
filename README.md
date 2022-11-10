# zUtil
A spigot plugin with multiple utilities

## Current commands:
 - /shout - Display your current coordinates and world in chat (+ conversions between the Nether and the Overworld)
 - /rlc - Alias for /reload confirm

## Compiling
### Prerequisites
 - A Spigot or Paper Minecraft server
 - Git
 - JDK 17
 - Maven
### Instructions
#### Linux/MacOS
```bash
$ git clone https://github.com/zylve/zutil.git
$ cd zutil
$ ./build.sh
```
You can find the jar file in the `target` directory. The build.sh script will attempt to move the jar file to `../server/plugins`. If your server is not located here you may move it manually.
#### Windows
Open a command prompt, and execute these commands
```bash
git clone https://github.com/zylve/zutil.git
cd zutil
mvn install
```
Your jar file will be in the `target` folder. You can then move this to your `server/plugins` folder.