package com.equital.resources.events;

import com.equital.resources.models.Resource;
import com.equital.resources.models.TableResourceApi;

public interface TableResourceListener<R extends Resource<?, ?>, I, A extends TableResourceApi<R, I>>
        extends CollectionResourceListener<R, I, A> {

    void disposed(I id, R child);

}
