//============================================================================//
//                                                                            //
//                         Copyright © 2015 Sandpolis                         //
//                                                                            //
//  This source file is subject to the terms of the Mozilla Public License    //
//  version 2. You may not use this file except in compliance with the MPL    //
//  as published by the Mozilla Foundation.                                   //
//                                                                            //
//============================================================================//
package com.sandpolis.plugin.device;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sandpolis.core.foundation.ConfigStruct;
import com.sandpolis.core.instance.state.st.STDocument;
import com.sandpolis.core.instance.store.ConfigurableStore;
import com.sandpolis.core.instance.store.STCollectionStore;
import com.sandpolis.plugin.device.DeviceStore.DeviceStoreConfig;

public class DeviceStore extends STCollectionStore<Device> implements ConfigurableStore<DeviceStoreConfig> {

	private static final Logger log = LoggerFactory.getLogger(DeviceStore.class);

	public DeviceStore() {
		super(log, Device::new);
	}

	@Override
	public void init(Consumer<DeviceStoreConfig> configurator) {
		var config = new DeviceStoreConfig();
		configurator.accept(config);

		setDocument(config.collection);
	}

	@ConfigStruct
	public static final class DeviceStoreConfig {

		public STDocument collection;
	}

	public static final DeviceStore DeviceStore = new DeviceStore();
}
