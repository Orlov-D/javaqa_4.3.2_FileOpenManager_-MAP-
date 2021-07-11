package ru.netology.manager;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class FileOpenManagerTest {
    private FileOpenManager fileOpenManager = new FileOpenManager();

    @Test
    public void someTest() {
        fileOpenManager.newElement(".jpg", new HashSet<>(Arrays.asList("Photoshop", "Фоторедактор", "Paint")));
//    fileOpenManager.newElement(".JPG",new HashSet<>(Collections.singletonList("Photoshop"))); затрется потому что новый однако
        fileOpenManager.newElement(".PSD", new HashSet<>(Collections.singletonList("Photoshop")));
        fileOpenManager.newElement(".txt", new HashSet<>());
        fileOpenManager.newElement(".xls", new HashSet<>(Collections.singletonList("Excel")));
        fileOpenManager.newElement(".md5", new HashSet<>());

//2. Получать название приложения, предназначенного для открытия файла с определённым расширением.
        HashSet<String> tmp = fileOpenManager.getAppName(".jpg");

//1. Регистрировать новое приложение для открытия файлов с определённым расширением
        fileOpenManager.newApp(".Jpg", "фотоМАСТЕР");

//4. Получать список всех зарегистрированных расширений, к которым привязаны приложения для открытия
        Set<String> tmp2 = fileOpenManager.getExtensionWithApps();

//5. Получать список всех приложений, которые привязаны к каким-либо расширениям
        Set<String> tmp3 = fileOpenManager.getAppsWithExtension();

//3. Удалять привязку приложения к определённому расширению
        fileOpenManager.delete(".txt");

        fileOpenManager.deleteRich(".jpG", "Photoshop");
        System.out.println("some shit");

    }
}