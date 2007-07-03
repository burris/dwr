/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.Class.defineClass("jsx3.net.Form",null,[jsx3.util.EventDispatcher],function(q,d){var
Lc=jsx3.util.Logger.getLogger(q.jsxclass.getName());q.lq=0;q.oT=250;q.t7=30000;q.METHOD_GET="get";q.METHOD_POST="post";q.SK="application/x-www-form-urlencoded";q.NI="multipart/form-data";q.EVENT_FILE_SELECTED="file";q.EVENT_ON_RESPONSE="response";q.EVENT_ON_ERROR="error";q.EVENT_ON_TIMEOUT="timeout";d.init=function(g,s,m){this.SU="jsx_httpform_"+q.lq++;if(g==-1){this.XX(s);}else{this.XX();this.setMethod(g!=null?g:"get");this.setAction(s);this.setMultipart(m);}};q.newFromFragment=function(k){return new
q(-1,k);};d.XX=function(l){var
qb=l;if(!qb)qb='<form method="get" action=""><input type="submit"/></form>';var
ac='<html><body class="jsx30form">'+qb+"</body></html>";jsx3.html.insertAdjacentHTML(document.body,"beforeEnd","<span id='"+this.SU+"_span' style='border:2px solid black;position:absolute;left:-50px;top:0px;width:10px;height:10px;overflow:hidden;'><iframe id='"+this.SU+"_frame' style='width:100%;height:100%;'></iframe></span>");this.os=document.getElementById(this.SU+"os");this.LS=this.eval(this.SU+"_frame");var
t=this.LS.document||this.LS.contentDocument;if(t==null)throw new
jsx3.Exception(jsx3._msg("htfrm.no_ifr",this));t.open();t.write(ac);t.close();this._form=t.getElementsByTagName("form")[0];if(l){if(this._form==null)throw new
jsx3.Exception(jsx3._msg("htfrm.bad_frag",l));this.s7=this._form.action;this.P2=this._form.method;this.X4=this._form.encoding&&this._form.encoding.toLowerCase()==q.NI;}};d.getMethod=function(){return this.P2;};d.setMethod=function(m){m=m!=null?m.toLowerCase():"get";this.P2=m;this.t8().setAttribute("method",m);};d.getAction=function(){return this.s7;};d.setAction=function(b){if(!jsx3.CLASS_LOADER.IE)b=jsx3.app.Browser.getLocation().resolve(b).toString();this.s7=b;this.t8().setAttribute("action",b);};d.getMultipart=function(){return this.X4;};d.setMultipart=function(r){this.X4=r;this.t8().setAttribute("encoding",r?q.NI:q.SK);};d.M7=function(){return this.os;};d.mO=function(){return this.LS;};d.t8=function(){return this._form;};d.getField=function(k){var
Z=this.t8().elements[k];return Z!=null&&typeof Z=="object"?Z.value:null;};d.getFields=function(){var
Cc=[];var
ac=this.t8().elements;for(var eb in ac)Cc[eb]=ac[eb].name;return Cc;};d.setField=function(i,f,m){var
Jb=this.t8();var
_=Jb.elements[i];if(_==null||typeof _!="object"){jsx3.html.insertAdjacentHTML(Jb,"beforeEnd","<div>"+i+": <input type='text' name='"+i+"'/></div>");_=Jb.elements[i];}if(m&&_.value){_.value=_.value+" "+f;}else _.value=f;};d.removeField=function(f){var
dc=this.t8();var
w=dc.elements[f];if(w!=null&&w.parentNode)w.parentNode.parentNode.removeChild(w.parentNode);};d.addFileUploadField=function(a){var
S=this.t8();var
Tb=S.elements[a];if(Tb==null||typeof Tb!="object"){jsx3.html.insertAdjacentHTML(S,"beforeEnd","<div>"+a+": <input type='file' name='"+a+"'/></div>");Tb=S.elements[a];var
J=this;Tb.onchange=function(){J.wX(a,Tb.value);};}else throw new
jsx3.Exception(jsx3._msg("htfrm.dup",this,a));};d.promptForFile=function(o){var
vb=this.t8();var
Wb=vb.elements[o];if(Wb!=null&&Wb.type=="file"){if(jsx3.CLASS_LOADER.IE){Wb.click();}else{Lc.warn(jsx3._msg("htfrm.prompt"));Wb.click();}}else throw new
jsx3.Exception(jsx3._msg("htfrm.no_file",this,o));};d.wX=function(i,g){this.publish({subject:"file",field:i,value:g});};d.Ys=function(){this._form=null;this.publish({subject:"response"});};d.dG=function(f){this._form=null;this.publish({subject:"error",message:f});};d.abort=function(){window.clearInterval(this.rO);};if(jsx3.CLASS_LOADER.IE){d.send=function(p,j){if(p==null)p=q.oT;if(j==null)j=q.t7;this._form.submit();var
bc=0;var
_b=j<=0?Number.MAX_VALUE:Math.ceil(j/p);var
J=this;this.rO=window.setInterval(function(){J.e1(++bc<_b);},p);};d.e1=function(k){try{this.LS.document.readyState=="";}catch(Kc){window.clearInterval(this.rO);this.rO=null;this.dG(jsx3._msg("htfrm.sec",this,jsx3.NativeError.wrap(Kc)));return;}if(this.LS.document.readyState=="complete"||this.LS.document.readyState=="loaded"){window.clearInterval(this.rO);this.rO=null;this.Ys();}else if(!k){window.clearInterval(this.rO);this.rO=null;this.destroy();this.publish({subject:"timeout"});}};d.getResponseText=function(){var
pb=this.LS.document;if(typeof pb.mimeType!="unknown")if(pb.mimeType.indexOf("XML")==0){return pb.XMLDocument.xml;}else if(pb.mimeType.indexOf("HTML")==0){return jsx3.html.getOuterHTML(this.LS.document.childNodes[0]);}else if(pb.mimeType.indexOf("Text")==0)return this.LS.document.childNodes[0].innerText;return this.LS.document.body.innerHTML;};d.getResponseXML=function(){var
db=this.LS.document;if(typeof db.mimeType=="string"&&db.mimeType.indexOf("XML")==0||db.XMLDocument&&db.XMLDocument.documentElement){var
H=new
jsx3.xml.Document();H.loadXML(db.XMLDocument.documentElement.xml);return H;}else{var
vc=null;if(db.mimeType.indexOf("HTML")==0){vc=jsx3.html.getOuterHTML(this.LS.document.childNodes[0]);}else if(db.mimeType.indexOf("Text")==0){vc=this.LS.document.childNodes[0].innerText;}else vc=this.LS.document.body.innerHTML;var
xc=new
jsx3.xml.Document();xc.loadXML(vc);if(xc.hasError()){Lc.error(jsx3._msg("htfrm.bad_xml",xc.getError()));return null;}return xc;}};}else{d.send=function(i,c){if(i==null)i=q.oT;if(c==null)c=q.t7;var
D=this;this.LS.onload=function(){D.Aq();};try{this._form.submit();}catch(Kc){this.dG(jsx3.NativeError.wrap(Kc).toString());return;}this.rO=window.setTimeout(function(){D.pW();},i*c);};d.Aq=function(){this.LS.onload=null;if(this.rO){window.clearTimeout(this.rO);this.rO=null;}try{var
D=" "+this.LS.contentDocument.childNodes[0].innerHTML;}catch(Kc){this.publish({subject:"error",message:jsx3.NativeError.wrap(Kc).toString()});return;}this.Ys();};d.pW=function(){this.LS.onload=null;this.rO=null;this.destroy();this.publish({subject:"timeout"});};d.getResponseText=function(){var
jb=this.LS.contentDocument;if(jb instanceof XMLDocument){return (new
XMLSerializer()).serializeToString(jb);}else if(jb instanceof HTMLDocument){return jb.childNodes[0].innerHTML;}else{Lc.warn(jsx3._msg("htfrm.bad_dt",jb));return "";}};d.getResponseXML=function(){var
Kb=this.LS.contentDocument;if(Kb instanceof XMLDocument){var
Yb=(new
XMLSerializer()).serializeToString(Kb);return (new
jsx3.xml.Document()).loadXML(Yb);}else if(Kb instanceof HTMLDocument){var
Yb=Kb.childNodes[0].innerHTML;return (new
jsx3.xml.Document()).loadXML(Yb);}else{Lc.warn(jsx3._msg("htfrm.bad_dt",Kb));return (new
jsx3.xml.Document()).loadXML("<html/>");}};}d.destroy=function(){var
nb=this.M7();if(nb!=null){nb.parentNode.removeChild(nb);this.os=null;this.LS=null;this._form=null;}else Lc.warn(jsx3._msg("htfrm.destr",this));};d.reveal=function(r,j,g,c){if(r==null)r=10;if(j==null)j=10;if(g==null)g=Math.round(this.os.parentNode.offsetWidth/3);if(c==null)c=Math.round(this.os.parentNode.offsetHeight/3);var
mc=this.os.style;mc.left=r+"px";mc.top=j+"px";mc.width=g+"px";mc.height=c+"px";mc.zIndex=30000;};d.conceal=function(){var
lb=this.os.style;lb.left="-50px";lb.top="0px";lb.width="10px";lb.height="10px";lb.zIndex=0;};});jsx3.HttpForm=jsx3.net.Form;
