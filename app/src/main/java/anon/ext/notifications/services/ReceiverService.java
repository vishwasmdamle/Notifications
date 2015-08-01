package anon.ext.notifications.services;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class ReceiverService extends NotificationListenerService {
  private static boolean isAttached = false;
  private final String TAG = getClass().getCanonicalName();

  public ReceiverService() {
  }

  @Override
  public IBinder onBind(Intent intent) {
    Log.e(TAG, "Notification Listener Service Attached");
    isAttached = true;
    return super.onBind(intent);
  }

  public static boolean isAttached() {
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
    return super.onUnbind(intent);
  }
}
