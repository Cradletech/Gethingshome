package com.cradle.gethingshome.repo;

import com.cradle.gethingshom.repo.impl.GTHDataRepoImpl;

public interface GTHDataRepo {
	public GTHDataRepoImpl open();
	public void close();
	public void createEntry(String name);
}
