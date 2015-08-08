package anon.ext.notifications.handlers;

import android.content.Context;

import anon.ext.notifications.actors.NotificationActor;
import anon.ext.notifications.services.ReceiverService;
import anon.ext.notifications.services.SharedPreferenceUtil;

public class NotificationLogicHandler {
  private final SharedPreferenceUtil sharedPreferenceUtil;
  private final NotificationActor actor;

  public NotificationLogicHandler(Context context, NotificationActor actor) {
    this(new SharedPreferenceUtil(context), actor);
  }

  public NotificationLogicHandler(SharedPreferenceUtil sharedPreferenceUtil, NotificationActor actor) {
    this.sharedPreferenceUtil = sharedPreferenceUtil;
    this.actor = actor;
  }

  public void onCreate() {
    if (!isReceiverEnabled()) {
      actor.startInfoActivity();
    }
  }

  private boolean isReceiverEnabled() {
    return sharedPreferenceUtil.getBoolean(ReceiverService.RECEIVER_STATUS, false);
  }
}
