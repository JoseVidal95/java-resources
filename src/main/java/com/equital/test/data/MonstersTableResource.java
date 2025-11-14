package com.equital.test.data;

import com.equital.listeners.TableResourceListener;
import com.equital.models.ResourceApi;
import com.equital.models.TableResourceApi;
import com.equital.resources.TableResourceImp;

public class MonstersTableResource
        extends TableResourceImp<String, MonsterResource, Integer, TableResourceListener<MonsterResource, Integer, TableResourceApi<MonsterResource, Integer>>, TableResourceApi<MonsterResource, Integer>> {

    public MonstersTableResource() {
        super();

        this.setApi(new TableResourceApi<MonsterResource, Integer>() {
            @Override
            public ResourceApi create(Integer id, MonsterResource child) {
                return new ResourceApi() {
                };
            }

            @Override
            public void initialize(MonsterResource child) {
            }

            @Override
            public void dispose(Integer id, MonsterResource child) {
            }
        });
    }

    @Override
    protected MonsterResource getChild(String value) {
        return new MonsterResourceImp(value);
    }

}
