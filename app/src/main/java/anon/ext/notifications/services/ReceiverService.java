package anon.ext.notifications.services;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class ReceiverService extends NotificationListenerService {
  public static final String RECEIVER_STATUS = ReceiverService.class.getCanonicalName() + ".receiverStatus";
  private boolean isAttached = false;
  private final String TAG = getClass().getCanonicalName();
  private Binder binder = new Binder();

  public ReceiverService() {
  }

  @Override
  public void onCreate() {
    super.onCreate();
  }

  @Override
  public IBinder onBind(Intent intent) {
    Log.e(TAG, "Notification Listener Service Attached");
    isAttached = true;
    new SharedPreferenceUtil(getApplicationContext()).put(RECEIVER_STATUS, isAttached);
    return binder;
  }

  public boolean isAttached() {
    return isAttached;
  }

  @Override
  public void onNotificationPosted(StatusBarNotification sbn) {
    super.onNotificationPosted(sbn);
  }

  @Override
  public void onNotificationRemoved(StatusBarNotification sbn) {
    super.onNotificationRemoved(sbn);
  }

  @Override
  public boolean onUnbind(Intent intent) {
    Log.e(TAG, "Notification Listener Service Detached");
    isAttached = false;
    new SharedPreferenceUtil(getApplicationContext()).put(RECEIVER_STATUS, isAttached);
    return super.onUnbind(intent);
  }

  public class Binder extends android.os.Binder {
    public ReceiverService getService() {
      return ReceiverService.this;
    }
  }
}
