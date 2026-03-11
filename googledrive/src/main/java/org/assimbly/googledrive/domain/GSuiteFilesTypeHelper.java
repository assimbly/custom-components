package org.assimbly.googledrive.domain;


import com.google.api.services.drive.model.File;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GSuiteFilesTypeHelper {

    private static final Map<String, String> mimeTypesMap = new ConcurrentHashMap<>();

    static {
        mimeTypesMap.put("application/vnd.google-apps.spreadsheet", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        mimeTypesMap.put("application/vnd.google-apps.document", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        mimeTypesMap.put("application/vnd.google-apps.drawing", "image/jpeg");
        mimeTypesMap.put("application/vnd.google-apps.presentation", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
    }

    public static String getConversionMimeType(String gSuiteMimeType) {

        if (mimeTypesMap.containsKey(gSuiteMimeType))
            return mimeTypesMap.get(gSuiteMimeType);

        return "application/pdf";
    }

    public static boolean isGSuiteFile(File file) {
        return file.getMimeType().contains("google-apps");
    }

    public static String getGSuiteFileName(File fileModel) {

        String extension = getFileExtension(fileModel.getMimeType());

        if (extension == null || fileModel.getName().toLowerCase().endsWith(extension))
            return fileModel.getName();

        return fileModel.getName() + extension;
    }

    private static String getFileExtension(String gSuiteMimeType) {
        return findFileExtension(getConversionMimeType(gSuiteMimeType));
    }

    public static String findFileExtension(String mimeType) {
        try {
            return MimeTypes.getDefaultMimeTypes().forName(mimeType).getExtension();
        } catch (MimeTypeException _) {
            return null;
        }
    }
}