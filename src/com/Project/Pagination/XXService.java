package com.Project.Pagination;

import com.Project.IdSpider.SFZ;

/**
 * add
 * delete
 * search
 * update
 */
public interface XXService {
    public void add(SFZ sfz);
    public void delete(int id);
    public void search(int id);
    public void update(int id,SFZ sfz);
}
