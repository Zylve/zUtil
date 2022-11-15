# zUtil
A spigot plugin with multiple utilities

## Current commands:
 - /shout - Display your current coordinates and world in chat (+ conversions between the Nether and the Overworld)
 - /rlc - Alias for /reload confirm
 - /stackcount and /sc - Display how many shulkers, stacks, and items are needed for a certain number

## Compiling
### Prerequisites
 - A Spigot or Paper Minecraft server
 - Git
 - JDK 17
### Instructions
#### Linux/MacOS
```bash
$ git clone https://github.com/zylve/zutil.git
$ cd zutil
$ ./build.sh [output folder] (defaults to ./compiledjars)
```
You can find the jar file in the `build/libs` directory.
#### Windows
Open a command prompt, and execute these commands
```bash
git clone https://github.com/zylve/zutil.git
cd zutil
gradlew.bat build
```
Your jar file will be in the `build/libs` folder. You can then move this to your `server/plugins` folder.