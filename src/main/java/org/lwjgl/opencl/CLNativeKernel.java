/*
 * Copyright (c) 2002-2010 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

import java.nio.ByteBuffer;

/**
 * Instances of this class can be used to execute native kernels. clEnqueueNativeKernel will build
 * the its arguments automatically, in a way that allows <code>execute</code> to receive an array
 * of ByteBuffers, pointing to cl_mem objects in global memory. The ByteBuffer objects should not
 * be used outside the handleMessage method.
 *
 * @author Spasi
 * @see CL10#clEnqueueNativeKernel
 * @see #execute(ByteBuffer[])
 */
public abstract class CLNativeKernel extends PointerWrapperAbstract {

	protected CLNativeKernel() {
		super(CallbackUtil.getNativeKernelCallback());
	}

	/**
	 * Implement this method to execute an action on cl_mem objects in global memory.
	 *
	 * @param memobjs an array of ByteBuffers pointing to cl_mem global memory.
	 */
	protected abstract void execute(ByteBuffer[] memobjs);

}