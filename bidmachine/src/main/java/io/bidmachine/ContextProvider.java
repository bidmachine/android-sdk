package io.bidmachine;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface ContextProvider {

    @NonNull
    Context getContext();

    @Nullable
    Activity getActivity();

    abstract class SimpleContextProvider implements ContextProvider {

        @Nullable
        @Override
        public Activity getActivity() {
            Context context = getContext();
            if (context instanceof Activity) {
                return (Activity) context;
            }
            return BidMachineImpl.getTopActivity();
        }
    }

}
