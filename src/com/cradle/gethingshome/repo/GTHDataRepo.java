package com.cradle.gethingshome.repo;


public interface GTHDataRepo {
	public com.cradle.gethingshome.repo.impl.GTHDataRepoImpl open();
	public void close();
	public long createEntry(String name);
}
