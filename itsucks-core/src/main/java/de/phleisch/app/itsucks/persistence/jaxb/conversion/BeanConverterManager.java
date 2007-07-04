/* Copyright (C) 2006-2007 Oliver Mihatsch (banishedknight@users.sf.net)
 * This is free software distributed under the terms of the
 * GNU Public License.  See the file COPYING for details. 
 *
 * $Id$
 * Created on 03.07.2007
 */

package de.phleisch.app.itsucks.persistence.jaxb.conversion;

import java.util.HashMap;
import java.util.Map;

public class BeanConverterManager {

	private Map<Class<?>, BeanConverter> mBeanConverter;
	private Map<Class<?>, BeanConverter> mClassConverter;
	
	public BeanConverterManager() {
		mBeanConverter = new HashMap<Class<?>, BeanConverter>();
		mClassConverter = new HashMap<Class<?>, BeanConverter>();
	}

	/**
	 * Gets an Converter which can convert the given type of class
	 * to an bean.
	 * @param pBean
	 * @param pConverter
	 */
	public BeanConverter getClassConverter(Class<?> pClass) {
		return mClassConverter.get(pClass);
	}

	/**
	 * Gets an Converter which can convert the given type of class
	 * to an bean.
	 * @param pBean
	 * @param pConverter
	 */
	public BeanConverter getBeanConverter(Class<?> pBean) {
		return mBeanConverter.get(pBean);
	}
	
	/**
	 * Registers an Converter which can convert the given type of class
	 * to an bean.
	 * @param pBean
	 * @param pConverter
	 */
	public void registerBeanConverter(Class<?> pBean, BeanConverter pConverter) {
		mBeanConverter.put(pBean, pConverter);
	}

	/**
	 * Registers an Converter which can convert the given type of bean class
	 * back to an normal object.
	 * @param pBean
	 * @param pConverter
	 */
	public void registerClassConverter(Class<?> pClass, BeanConverter pConverter) {
		mClassConverter.put(pClass, pConverter);
	}
	
}
