# gradle build
# mv build/libs/*.jar ../server/plugins/
if [[! command -v gradle &> /dev/null ]]; then
    ./gradle build
else
    gradle build
fi


if [[ "$1" = "" ]]; then
    mkdir compiledjars
    mv build/libs/*.jar compiledjars
    exit
fi

if [[ -d "$1" ]]; then
    mv build/libs/*.jar $1
else
    echo "Directory could not be found!"
fi