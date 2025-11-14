package com.equital.listeners;

import com.equital.models.Resource;
import com.equital.models.TableResourceApi;

public interface TableResourceListener<R extends Resource<?, ?>, I, A extends TableResourceApi<R, I>>
        extends CollectionResourceListener<R, I, A> {

    void disposed(I id, R child);

}
