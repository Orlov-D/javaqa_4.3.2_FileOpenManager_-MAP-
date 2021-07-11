package ru.netology.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileOpenManager {
    private Map<String, HashSet<String>> fileManager = new HashMap<String, HashSet<String>>();

    public void newElement(String extension, HashSet<String> appName) {
        fileManager.put(extension.toLowerCase(), appName);
    }

    public HashSet<String> getAppName(String extension) {
        return fileManager.get(extension.toLowerCase());
    }

    public void newApp(String extension, String newAppName) {
//        if (this.getAppName(extension.toLowerCase()) == null) {
//            System.out.println("Пусто");
//        } else {
        HashSet<String> tmp = this.getAppName(extension.toLowerCase());
        tmp.add(newAppName);
        this.newElement(extension.toLowerCase(), tmp);
//        }
    }

    public Set<String> getExtensionWithApps() {
        Set<String> extensions = fileManager.keySet();
        Set<String> extensionsWithApps = new HashSet<>();
        for (String extension : extensions) {
            if (fileManager.get(extension).size() != 0) {
                extensionsWithApps.add(extension);
            }
        }
        return extensionsWithApps;
    }

    public Set<String> getAppsWithExtension() {
        Set<String> extensions = this.getExtensionWithApps();
        Set<String> AppsWithExtension = new HashSet<>();
        for (String extension : extensions) {
            if (fileManager.get(extension).size() != 0) {
                AppsWithExtension.addAll(fileManager.get(extension));
            }
        }
        return AppsWithExtension;
    }

    public void delete(String extension) {
        fileManager.remove(extension);
    }

    public void deleteRich(String extension, String AppName){
        HashSet<String> AppNames = fileManager.get(extension.toLowerCase());
        for (String tmp: AppNames){
            if (tmp == AppName){
                AppNames.remove(AppName);
            }
        }
        fileManager.replace(extension, AppNames);
    }
}
