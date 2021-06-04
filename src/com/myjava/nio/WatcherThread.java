package com.myjava.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Date;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WatcherThread extends Thread {

    private String dirName;

    public WatcherThread(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public void run() {
        System.out.println("Watcher is started");
        fileWatcher();
        System.out.println("Watcher is ended");
    }

    public void fileWatcher() {
        try {
            Path dir = Paths.get(dirName);
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);


            WatchKey key;
            for (int i = 0; i < 4; i++) {
                key = watcher.take();
                String watchedTime = new Date().toString();
                List<WatchEvent<?>> eventList = key.pollEvents();
                for (WatchEvent<?> event : eventList) {
                    Path name = (Path) event.context();
                    if (event.kind() == ENTRY_CREATE) {
                        System.out.format("%s created at %s%n", name, watchedTime);
                    } else if (event.kind() == ENTRY_DELETE) {
                        System.out.format("%s delted at %s%n", name, watchedTime);
                    } else if (event.kind() == ENTRY_MODIFY) {
                        System.out.format("%s modified at %s%n", name, watchedTime);
                    }
                }
                key.reset();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
