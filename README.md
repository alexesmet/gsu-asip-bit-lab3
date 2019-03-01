## Ficus Notes

### What it does
This is command line application with ability to switch to GUI. This application temporary stores notes. This is how CLI looks like:
```
   |      ______ _                _   _       _            
 .'|'.   |  ____(_)              | \ | |     | |
/.'|\ \  | |__   _  ___ _   _ ___|  \| | ___ | |_ ___  ___ 
| /|'.|  |  __| | |/ __| | | / __| . ` |/ _ \| __/ _ \/ __|
 \ |\/   | |    | | (__| |_| \__ \ |\  | (_) | ||  __/\__ \
  \|/    |_|    |_|\___|\__,_|___/_| \_|\___/ \__\___||___/
   `
Welcome to FicusNotes, console interface. 
Available commands (case sensitive): 
add [title] [text] -- add new note. Title should be single-word (no spaces). 
lst -- list all saved notes. 
clr -- delete all notes.
gui -- open GUI.
hlp -- show this help page. 
ext -- close application (all notes will be deleted).

::: 
```

This is how GUI looks like:

![GUI](https://i.imgur.com/KXTkKcs.png)


### What it uses
  - Java
  - JavaFX
  - Maven

### How to compile it
Just execute `mvn clean package` command in this folder.
