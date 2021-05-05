package io.bidmachine;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.explorestack.protobuf.adcom.Context;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private final String id;
    private final String name;
    private final String domain;
    private final List<String> categories;

    private Publisher(@Nullable String id,
                      @Nullable String name,
                      @Nullable String domain,
                      @Nullable List<String> categories) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.categories = categories;
    }

    void build(Context.App.Builder builder) {
        Context.App.Publisher.Builder publisherBuilder = Context.App.Publisher.newBuilder();
        if (id != null) {
            publisherBuilder.setId(id);
        }
        if (name != null) {
            publisherBuilder.setName(name);
        }
        if (domain != null) {
            publisherBuilder.setDomain(domain);
        }
        if (categories != null) {
            publisherBuilder.addAllCat(categories);
        }
        builder.setPub(publisherBuilder.build());
    }

    public static final class Builder {

        private String id;
        private String name;
        private String domain;
        private List<String> categories;

        public Builder setId(@Nullable String id) {
            this.id = id;
            return this;
        }

        public Builder setName(@Nullable String name) {
            this.name = name;
            return this;
        }

        public Builder setDomain(@Nullable String domain) {
            this.domain = domain;
            return this;
        }

        public Builder addCategory(@Nullable String category) {
            if (TextUtils.isEmpty(category)) {
                return this;
            }
            if (categories == null) {
                categories = new ArrayList<>();
            }
            categories.add(category);
            return this;
        }

        public Builder addCategories(@Nullable List<String> categoryList) {
            if (categoryList == null || categoryList.isEmpty()) {
                return this;
            }
            for (String category : categoryList) {
                addCategory(category);
            }
            return this;
        }

        public Publisher build() {
            return new Publisher(id, name, domain, categories);
        }

    }

}