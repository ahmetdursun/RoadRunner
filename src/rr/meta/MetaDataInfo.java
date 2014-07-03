/******************************************************************************

Copyright (c) 2010, Cormac Flanagan (University of California, Santa Cruz)
                    and Stephen Freund (Williams College) 

All rights reserved.  

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.

    * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the following
      disclaimer in the documentation and/or other materials provided
      with the distribution.

    * Neither the names of the University of California, Santa Cruz
      and Williams College nor the names of its contributors may be
      used to endorse or promote products derived from this software
      without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

******************************************************************************/

package rr.meta;

import acme.util.decorations.Decoratable;

public abstract class MetaDataInfo extends Decoratable implements Comparable<MetaDataInfo> {

	protected final int id;
	protected SourceLocation loc;
	protected String key;
	

	public MetaDataInfo(int id, SourceLocation loc) {
		this.id = id;
		this.loc = loc;
	}
	
	public int getId() {
		return id;
	}

	public SourceLocation getLoc() {
		return loc;
	}

	public void setLoc(SourceLocation loc) {
		this.loc = loc;
	}

	public String accessViaSource() {
		return "MetaDataInfoMaps.get" + this.getClass().getSimpleName() + "(" + this.computeKey() + ")";
	}
	
	@Override
	public String toString() {
		return getKey();
	}
	
	protected abstract String computeKey();
	
	public final String getKey() {
		if (key == null) {
			key = computeKey();
		}
		return key;
	}
	
	public abstract void accept(MetaDataInfoVisitor v);

	public int compareTo(MetaDataInfo other) {
	    return getKey().compareTo(other.getKey());
	}

}
