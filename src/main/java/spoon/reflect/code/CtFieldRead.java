/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon.reflect.code;

/**
 * This code element defines a read access to a field.
 *
 * In Java, it is a usage of a field outside an assignment. For example,
 * <pre>
 *     class Foo { int field; }
 *     Foo x = new Foo();
 *     System.out.println(x.field);
 * </pre>
 *
 *
 * @param <T>
 * 		type of the field
 */
public interface CtFieldRead<T> extends CtFieldAccess<T>, CtVariableRead<T> {
	@Override
	CtFieldRead<T> clone();
}
