/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.inria.controlflow;

import org.jgrapht.DirectedGraph;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.visitor.CtVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent for all transfer function visitors.
 * <p>
 * These visitors are meant to be the transfer functions of control flow nodes.
 */
public abstract class TransferFunctionVisitor implements CtVisitor {

	/**
	 * Control graph over the data flow is being exists
	 */
	DirectedGraph<CtStatement, CtStatement> controlGraph;

	/**
	 * Outputs of the statement calling the transfer.
	 */
	protected List<Value> output;

	public DirectedGraph<CtStatement, CtStatement> getControlGraph() {
		return controlGraph;
	}

	public void setControlGraph(DirectedGraph<CtStatement, CtStatement> controlGraph) {
		this.controlGraph = controlGraph;
	}

	/**
	 * Output of the last node that called the transfer function
	 */
	public List<Value> getOutput() {
		if (output == null) {
			output = new ArrayList<>();
		}
		return output;
	}

	public List<Value> transfer(CtElement statement) {
		output = new ArrayList<>();
		statement.accept(this);
		return output;
	}


}
