package org.ei.opensrp;

import android.content.res.AssetManager;

import org.ei.opensrp.repository.AllSharedPreferences;
import org.ei.opensrp.util.IntegerUtil;

import java.io.IOException;
import java.util.Properties;

public class DristhiConfiguration {

    protected static final String HOST = "HOST";
    protected static final String PORT = "PORT";
    protected static final String SHOULD_VERIFY_CERTIFICATE = "SHOULD_VERIFY_CERTIFICATE";
    protected static final String SYNC_DOWNLOAD_BATCH_SIZE = "SYNC_DOWNLOAD_BATCH_SIZE";
    protected static final String APP_NAME = "APP_NAME";
    protected static final String SYNC_FORM = "SYNC_FORM";
    protected static AllSharedPreferences preferences;
    protected Properties properties = new Properties();
    protected String dummyData = null;

    public DristhiConfiguration(AssetManager assetManager) {
        preferences=Context.getInstance().allSharedPreferences();
        try {
            properties.load(assetManager.open("app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDummyData() { return this.dummyData; }

    private String get(String key) {
        return properties.getProperty(key);
    }

    public String host() {

        return this.get(HOST);

    }

    public int port() {


        return preferences.fetchPort(Integer.parseInt(this.get(PORT)));
    }

    public boolean shouldVerifyCertificate() {
        return Boolean.parseBoolean(this.get(SHOULD_VERIFY_CERTIFICATE));
    }

    public String dristhiBaseURL() {

        return preferences.fetchBaseURL(this.get(AllConstants.DRISHTI_BASE_URL));
    }

    public int syncDownloadBatchSize() {
        return IntegerUtil.tryParse(this.get(SYNC_DOWNLOAD_BATCH_SIZE), 100);
    }

    public String appName() {
        return this.get(APP_NAME) != null ? this.get(APP_NAME) : "";
    }

    public boolean shouldSyncForm() {
        return this.get(SYNC_FORM) != null ? Boolean.parseBoolean(this.get(SYNC_FORM)) : false;
    }
}
