/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.IFrame",jsx3.gui.Block,null,function(p,s){p.SCROLLYES=1;p.SCROLLNO=2;p.SCROLLAUTO=3;p.Bx={1:"yes",2:"no",3:"auto"};s.paint=function(){this.applyDynamicProperties();var
K=this.getSrc();K=K?' src="'+this.getUriResolver().resolveURI(K)+'"':"";return '<span id="'+this.getId()+'" class="jsx30iframe" style="'+this.Af()+this.Dh()+this.ji()+'"'+this.renderAttributes()+">"+'<iframe id="'+this.getId()+'_iframe" class="jsx30iframe" frameborder="0"'+K+this.M9()+this.cn("load","S3",1)+"></iframe>"+"</span>";};s.getIFrame=function(){try{return this.eval(this.getId()+"_iframe");}catch(Kc){return null;}};s.getContentDocument=function(){try{var
qb=this.getIFrame();if(qb)if(jsx3.CLASS_LOADER.IE){return qb.document;}else return qb.contentDocument;}catch(Kc){}return null;};s.S3=function(f,g){this.doEvent("jsxload",{objEVENT:f});};s.getSrc=function(){return this.jsxsrc;};s.setSrc=function(l){this.jsxsrc=l;if(jsx3.CLASS_LOADER.IE){var
pb=this.getContentDocument();if(pb)pb.location.href=this.getUriResolver().resolveURI(l).toString();}else{var
Pb=this.getIFrame();if(Pb)Pb.setAttribute("src",this.getUriResolver().resolveURI(l));}return this;};s.getScrolling=function(){return this.jsxscroll;};s.setScrolling=function(b){this.jsxscroll=b;return this;};s.M9=function(){var
Nb=p.Bx[this.jsxscroll];return Nb?' scrolling="'+Nb+'"':"";};s.onSetChild=function(c){return false;};s.zj=function(l){return null;};s.Vd=function(f,c,l){};});
