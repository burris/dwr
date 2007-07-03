/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.Package.definePackage("jsx3.chart",function(k){k.sj=k.ADDIN.getVersion();k.tk=k.ADDIN.getPath()+"properties/";k.Fd=k.ADDIN.getPath()+"events/";k.LOG=jsx3.util.Logger.getLogger(k.jsxpackage.getName());k.LOG_BENCH=jsx3.util.Logger.getLogger(k.jsxpackage.getName()+".benchmark");k.QTOP="top";k.QRIGHT="right";k.QBOTTOM="bottom";k.QLEFT="left";k.splitBox=function(a,d,s,e,c,b,q){var
tc=null,qc=null;if(c=="top"){tc=[a,d,s,Math.min(q,e-1)];qc=[a,d+tc[3],s,e-tc[3]];}else if(c=="right"){var
gc=Math.min(b,s-1);tc=[a+s-gc,d,gc,e];qc=[a,d,s-gc,e];}else if(c=="bottom"){var
G=Math.min(q,e-1);tc=[a,d+e-G,s,G];qc=[a,d,s,e-G];}else if(c=="left"){tc=[a,d,Math.min(b,s-1),e];qc=[a+tc[2],d,s-tc[2],e];}return [tc,qc];};k.isValueAxis=function(i){return k.LinearAxis&&i instanceof k.LinearAxis||k.LogarithmicAxis&&i instanceof k.LogarithmicAxis;};k.isCategoryAxis=function(m){return k.CategoryAxis&&m instanceof k.CategoryAxis;};k.Ij=function(j){if(j==null)return null;var
sb=j.split(/\s*[,;]\s*/);if(sb[0]==="")sb.shift();if(sb.length>0&&sb[sb.length-1]==="")sb.pop();return sb;};k.asNumber=function(o){if(o==null)return null;if(typeof o=="number")return o;return new
Number(o);};k.parseGradient=function(d){if(!d)return null;var
Kc=d.split(/\s+/);if(Kc[0]==="")Kc.shift();if(Kc.length>0&&Kc[Kc.length-1]==="")Kc.pop();if(Kc.length==0)return null;if(Kc.length>4)return [Kc[0],Kc[1],Kc[2],Kc.slice(3).join(" ")];return Kc;};k.addGradient=function(e,r){var
z=k.parseGradient(r);if(e!=null&&z!=null){var
kb=new
jsx3.vector.Fill(e.getColor(),e.getAlpha());kb.setType("gradient");kb.setColor2(z[0]);kb.setAngle(z[1]);kb.setAlpha2(z[2]);kb.setColors(z[3]);return kb;}else return e;};});if(jsx3.IDE){jsx3.ide.loadTemplateCatalog("prop","properties/catalog.xml",jsx3.chart.ADDIN);jsx3.ide.loadTemplateCatalog("event","events/catalog.xml",jsx3.chart.ADDIN);}jsx3.Package.definePackage("jsx3.vector",function(g){g.Li="px";g.Yh="v";g.aj=function(s){return typeof s=="number"?"#"+(s+16777216).toString(16).substring(1):""+s;};g.Zj=function(m,q,b){if(m==null)m=0;if(q==null)q="px";if(typeof m=="number"){return m+""+q;}else{m=m.toString();m=m.replace(/^\s*(.*?)\s*$/,"$1");if(b)m=m.replace(/[^\d\.]/g,"");return m.match(/[^\d\.]/)?m:m+""+q;}};g.tg=function(a,s){return g.Zj(a)+","+g.Zj(s);};g.Zk=function(d,c){return g.Zj(d,"",true)+" "+g.Zj(c,"",true);};g.Ud=function(p){return Math.max(0,Math.min(1,p));};g.degreesToRadians=function(s){return jsx3.util.numMod(2*Math.PI/360*(-1*s+90),2*Math.PI);};});jsx3.Class.defineClass("jsx3.html.Tag",null,null,function(g,q){var
Kb=jsx3.Exception;g.dv=[];q.a9=null;q.Zs=null;if(jsx3.CLASS_LOADER.VML){q.init=function(e,m){this.a9=m;this.Zs=e;this.Xd=document.createElement(e?e+":"+m:m);this.Kv=null;this.q1=null;};q.appendChild=function(c){if(this.Qc(c)){if(c instanceof g&&c.getParent()!=null)throw new
Kb("can't append "+c+" to "+this+", already has parent "+c.Kv);if(this.q1==null)this.q1=[];this.q1.push(c);c.Kv=this;}else throw new
Kb("Illegal to append child "+c+" to parent "+this+".");};q.removeChild=function(d){if(this.q1){var
Pb=jsx3.util.arrIndexOf(this.q1,d);if(Pb>=0){this.q1[Pb].Kv=null;this.q1.splice(Pb,1);}}};q.replaceChild=function(h,i){if(this.q1){var
I=jsx3.util.arrIndexOf(this.q1,i);if(I>=0){this.q1[I].Kv=null;this.q1[I]=h;h.Kv=this;}}};q.removeChildren=function(){if(this.q1)this.q1.splice(0,this.q1.length);};}else if(jsx3.CLASS_LOADER.SVG){q.init=function(f,n){this.a9=n;this.Zs=f;if(n)this.Xd=f?document.createElementNS(f,n):document.createElement(n);this.Kv=null;this.q1=null;};q.appendChild=function(n){if(this.Qc(n)){if(n instanceof g&&n.getParent()!=null)throw new
Kb("can't append "+n+" to "+this+", already has parent "+n.Kv);if(this.q1==null)this.q1=[];this.q1.push(n);n.Kv=this;this.Xd.appendChild(n.Xd);}else throw new
Kb("Illegal to append child "+n+" to parent "+this+".");};q.removeChild=function(d){if(this.q1){var
wb=jsx3.util.arrIndexOf(this.q1,d);if(wb>=0){this.q1[wb].Kv=null;this.q1.splice(wb,1);}}this.Xd.removeChild(d.Xd);};q.replaceChild=function(j,e){if(this.q1){var
W=jsx3.util.arrIndexOf(this.q1,e);if(W>=0){this.q1[W].Kv=null;this.q1[W]=j;j.Kv=this;}}this.Xd.replaceChild(j.Xd,e.Xd);};q.removeChildren=function(){if(this.q1)this.q1.splice(0,this.q1.length);var
hc=this.Xd.childNodes;for(var
Kc=hc.length-1;Kc>=0;Kc--)this.Xd.removeChild(hc[Kc]);};}q.getParent=function(){return this.Kv;};q.getChildren=function(){return this.q1==null?g.dv:this.q1;};q.getId=function(){return this.Xd.id;};q.setId=function(l){this.setProperty("id",l);};q.getClassName=function(){return this.Xd.className;};q.setClassName=function(n){this.setProperty("className",n);};q.setExtraStyles=function(f){try{this.Xd.style.cssText+=(";"+f);}catch(Kc){throw new
Kb("Error appending '"+f+"' to 'cssText': "+jsx3.NativeError.wrap(Kc));}};q.release=function(){delete this.Kv;if(this.q1){for(var
gc=this.q1.length-1;gc>=0;gc--)if(this.q1[gc].release)this.q1[gc].release();delete this.q1;}};q.Qc=function(n){return true;};q.bj=function(o){return true;};q.setProperty=function(j,e){var
Ic=arguments;for(var
Ec=0;Ec<Ic.length;Ec=Ec+2){j=Ic[Ec];e=Ic[Ec+1];if(e!=null)this.Xd.setAttribute(j,e);else this.Xd.removeAttribute(j);}};if(jsx3.CLASS_LOADER.SVG)q.setPropertyNS=function(b,a,n){if(n!=null)this.Xd.setAttributeNS(b,a,n);else this.Xd.removeAttributeNS(b,a);};q.getProperty=function(i){return this.Xd.getAttribute(i);};q.removeProperty=function(l){var
S=arguments;for(var
ec=0;ec<S.length;ec++)this.Xd.removeAttribute(S[ec]);};q.setStyle=function(m,b){var
Db=arguments;for(var
G=0;G<Db.length;G=G+2){m=Db[G];b=Db[G+1];try{this.Xd.style[m]=b==null?"":b;}catch(Kc){throw new
Kb("Error setting style '"+m+"' to '"+b+"': "+jsx3.NativeError.wrap(Kc));}}};q.getStyle=function(l){return this.Xd.style[l];};q.removeStyle=function(s){var
lb=arguments;for(var
Jc=0;Jc<lb.length;Jc++)this.Xd.style[lb[Jc]]="";};q.getTagName=function(){return this.a9;};q.getTagNS=function(){return this.Zs;};if(jsx3.CLASS_LOADER.VML){q.paint=function(){this.paintUpdate();var
ec=[];var
D=this.zl(ec,0);return ec.slice(0,D).join("");};q.zl=function(k,s){var
gb=this.q1;var
sb=jsx3.html.getOuterHTML(this.Xd);sb=sb.replace(/^<(\w+(\:\w+)?)\b/,function(d,f){return "<"+f.toLowerCase();});sb=sb.replace(/\b([_a-zA-Z]\w*)=([^\s\"]+) /g,'$1="$2" ');var
v=sb.lastIndexOf("</");if(v>=0&&sb.substring(v).indexOf(this.Xd.nodeName)!=2)v=-1;if(gb!=null&&gb.length>0){var
xb=null,zb=null;if(v>=0){xb=sb.substring(0,v);zb=sb.substring(v);}else{xb=sb;zb="</"+this.Xd.nodeName.toLowerCase()+">";}k[s++
]=xb;for(var
jb=0;jb<gb.length;jb++){var
ab=gb[jb];if(typeof ab=="string")k[s++
]=ab;else s=ab.zl(k,s);}k[s++
]=zb;}else{if(v>=0)k[s++
]=sb.substring(0,v-1);else k[s++
]=sb.substring(0,sb.length-1);k[s++
]="/>";}return s;};}else if(jsx3.CLASS_LOADER.SVG)q.paintDom=function(){this.paintUpdate();return this.Xd;};q.paintUpdate=function(){var
xc=this.q1;if(xc)for(var
bb=0;bb<xc.length;bb++)xc[bb].paintUpdate();};q.toString=function(){return "<"+this.getTagName()+"#"+this.getId()+"/>";};q.getFirstChildOfType=function(k){if(typeof k=="string")k=jsx3.Class.forName(k).getConstructor();if(this.q1){var
bb=this.q1;for(var
ub=0;ub<bb.length;ub++)if(bb[ub] instanceof k)return bb[ub];}return null;};});jsx3.Class.defineClass("jsx3.html.Text",jsx3.html.Tag,null,function(q,g){if(jsx3.CLASS_LOADER.VML){g.init=function(p){this.l8=p;};g.zl=function(a,j){a[j]=this.l8;return j+1;};g.getText=function(){return this.l8;};g.setText=function(b){this.l8=b;};g.paint=function(){return this.l8;};}else if(jsx3.CLASS_LOADER.SVG){g.init=function(n){this.Xd=document.createTextNode(n!=null?n:"");};g.getText=function(){return this.Xd.nodeValue;};g.setText=function(l){this.Xd.nodeValue=l;};}g.Qc=function(k){return false;};g.toString=function(){return '[jsx3.html.Text "'+this.getText()+'"]';};});jsx3.Class.defineClass("jsx3.html.BlockTag",jsx3.html.Tag,null,function(b,l){l.init=function(c,q,r,e,h,f){this.jsxsuper(c,q);this.setDimensions(r,e,h,f);};l.getLeft=function(){var
Kc=this.getStyle("left");return Kc!=null?parseInt(Kc):null;};l.zJ=function(q,m){if(m==null){this.setStyle(q,null);}else{var
P=parseInt(m);if(isNaN(P))jsx3.chart.LOG.debug("trying to set "+q+" of "+this+" to "+m);else this.setStyle(q,P+"px");}};l.setLeft=function(a){this.zJ("left",a);};l.getTop=function(){var
qb=this.getStyle("top");return qb!=null?parseInt(qb):null;};l.setTop=function(r){this.zJ("top",r);};l.getWidth=function(){var
Ic=this.getStyle("width");return Ic!=null?parseInt(Ic):null;};l.setWidth=function(a){this.zJ("width",a);};l.getHeight=function(){var
ub=this.getStyle("height");return ub!=null?parseInt(ub):null;};l.setHeight=function(i){this.zJ("height",i);};l.getMargin=function(){return this.getStyle("margin");};l.setMargin=function(o){this.setStyle("margin",o);};l.getPadding=function(){return this.getStyle("padding");};l.setPadding=function(a){this.setStyle("padding",a);};l.getPosition=function(){return this.getStyle("position");};l.setPosition=function(j){this.setStyle("position",j);};l.getZIndex=function(){return this.getStyle("zIndex");};l.setZIndex=function(m){this.setStyle("zIndex",m);};l.getBackgroundColor=function(){return this.getStyle("backgroundColor");};l.setBackgroundColor=function(c){this.setStyle("backgroundColor",c);};l.getMarginDimensions=function(){return b.Rf(this.getMargin());};l.getPaddingDimensions=function(){return b.Rf(this.getPadding());};b.Rf=function(c){if(c)if(typeof c=="number"){return [c,c,c,c];}else{var
v=(""+c).split(/[^\d\-]+/);if(v[0]==="")v.shift();if(v.length>0&&v[v.length]==="")v.pop();if(v.length>=4){return [parseInt(v[0]),parseInt(v[1]),parseInt(v[2]),parseInt(v[3])];}else if(v.length>=1){var
G=parseInt(v[0]);return [G,G,G,G];}}return [0,0,0,0];};l.getDimensions=function(){return [this.getLeft(),this.getTop(),this.getWidth(),this.getHeight()];};l.setDimensions=function(k,n,i,o){if(k instanceof Array){this.setLeft(k[0]);this.setTop(k[1]);this.setWidth(k[2]);this.setHeight(k[3]);}else{this.setLeft(k);this.setTop(n);this.setWidth(i);this.setHeight(o);}};});jsx3.Class.defineInterface("jsx3.html.FontTag",null,function(q,s){s.getFontFamily=function(){return this.getStyle("fontFamily");};s.setFontFamily=function(a){this.setStyle("fontFamily",a);};s.getFontSize=function(){return this.getStyle("fontSize");};s.setFontSize=function(h){this.setStyle("fontSize",isNaN(h)?h:h+"px");};s.getFontStyle=function(){return this.getStyle("fontStyle");};s.setFontStyle=function(f){this.setStyle("fontStyle",f);};s.getFontWeight=function(){return this.getStyle("fontWeight");};s.setFontWeight=function(e){this.setStyle("fontWeight",e);};s.getTextAlign=function(){return this.getStyle("textAlign");};s.setTextAlign=function(l){this.setStyle("textAlign",l);};s.getTextDecoration=function(){return this.getStyle("textDecoration");};s.setTextDecoration=function(j){this.setStyle("textDecoration",j);};s.getColor=function(){return this.getStyle("color");};s.setColor=function(r){this.setStyle("color",r);};});jsx3.Class.defineClass("jsx3.vector.Canvas",jsx3.html.BlockTag,null,function(s,a){a.init=function(m,p,g,q){this.jsxsuper(jsx3.vector.Yh,"group",m,p,g,q);this.setProperty("xmlns:v","urn:schemas-microsoft-com:vml");};a.paintUpdate=function(){this.jsxsuper();if(this.getWidth()&&this.getHeight()){this.setProperty("coordsize",jsx3.vector.Zk(parseInt(this.getWidth()),parseInt(this.getHeight())));}else this.setProperty("coordsize",jsx3.vector.Zk(100,100));if(this.getPosition()!="absolute"){this.setLeft(null);this.setTop(null);}};});jsx3.Class.defineClass("jsx3.vector.Tag",jsx3.html.BlockTag,null,function(j,a){a.init=function(q,b,e,r,f){this.jsxsuper(jsx3.vector.Yh,q,b,e,r,f);};a.getToolTip=function(){return this.getProperty("title");};a.setToolTip=function(q){this.setProperty("title",q);};a.getRotation=function(){return this.getStyle("rotation");};a.setRotation=function(l){this.setStyle("rotation",l);};a.paintUpdate=function(){this.jsxsuper();var
pb=this.getParent();if(this.getWidth()&&this.getHeight()){this.setProperty("coordsize",jsx3.vector.Zk(parseInt(this.getWidth()),parseInt(this.getHeight())));}else this.removeProperty("coordsize");};});jsx3.Class.defineClass("jsx3.vector.Stroke",jsx3.html.Tag,null,function(m,s){var
gb=jsx3.vector;m.en="stroke";s.init=function(p,j,h){this.jsxsuper(gb.Yh,m.en);this.vv=null;this.P5=p!=null?p:0;this.qA=j!=null?j:1;this.yY=h!=null?gb.Ud(h):1;};s.getColor=function(){return this.P5;};s.getColorHtml=function(){return gb.aj(this.P5);};s.setColor=function(e){this.P5=e;};s.getWidth=function(){return this.qA;};s.setWidth=function(n){this.qA=n;};s.getAlpha=function(){return this.yY;};s.setAlpha=function(p){this.yY=p!=null?gb.Ud(p):null;};s.Qc=function(n){return false;};s.toString=function(){return "<stroke "+this.getColorHtml()+" "+this.qA+" "+this.yY+"/>";};s.paint=function(){var
qb="<"+gb.Yh+":"+this.getTagName();if(this.getId()!=null)qb=qb+(" id='"+this.getId()+"'");var
db=this.getColorHtml();if(this.vv!=null)qb=qb+(" on='"+this.vv+"'");if(db!=null)qb=qb+(" color='"+db+"'");if(this.yY!=null&&this.yY<1)qb=qb+(" opacity='"+this.yY+"'");if(this.qA!=null)qb=qb+(" weight='"+gb.Zj(this.qA)+"'");qb=qb+"/>";return qb;};s.zl=function(i,b){i[b]=this.paint();return b+1;};s.Jd=function(){return this.yY==1||this.yY==null;};m.valueOf=function(k){if(jsx3.util.strEmpty(k))return null;if(k instanceof m)return k;var
Db=k.toString().split(/\s+/);return new
m(Db[0],Db[1],Db[2]);};});jsx3.Class.defineClass("jsx3.vector.Fill",jsx3.html.Tag,null,function(c,b){var
gb=jsx3.vector;c.en="fill";b.init=function(e,m){this.jsxsuper(gb.Yh,c.en);this.vv=null;this.P5=e!=null?e:0;this.yY=m!=null?gb.Ud(m):1;this.n8=null;this.L2=null;this.Sp=null;this.vJ=null;this.CR=null;};b.getColor=function(){return this.P5;};b.getColorHtml=function(){return gb.aj(this.P5);};b.setColor=function(s){this.P5=s;};b.getAlpha=function(){return this.yY;};b.setAlpha=function(l){this.yY=l!=null?gb.Ud(l):null;};b.getType=function(){return this.n8;};b.setType=function(g){this.n8=g;};b.getColor2=function(){return this.L2;};b.getColor2Html=function(){return gb.aj(this.L2);};b.setColor2=function(n){this.L2=n;};b.getAlpha2=function(){return this.Sp;};b.setAlpha2=function(m){this.Sp=m;};b.getAngle=function(){return this.vJ;};b.setAngle=function(l){this.vJ=l;};b.getColors=function(){return this.CR;};b.setColors=function(l){this.CR=l;};b.toString=function(){return "<fill "+this.getColorHtml()+" "+this.getAlpha()+"/>";};b.paint=function(){var
O="<"+gb.Yh+":"+this.getTagName();if(this.getId()!=null)O=O+(" id='"+this.getId()+"'");var
mb=this.getColorHtml();if(this.vv!=null)O=O+(" on='"+this.vv+"'");if(mb!=null)O=O+(" color='"+mb+"'");if(this.yY!=null&&this.yY<1)O=O+(" opacity='"+this.yY+"'");if(this.n8&&this.n8!="solid"){O=O+(" type='"+this.n8+"'");var
yb=this.getColor2Html();if(yb!=null)O=O+(" color2='"+yb+"'");if(this.CR!=null)O=O+(" colors='"+this.CR+"'");if(this.vJ!=null)O=O+(" angle='"+this.vJ+"'");if(this.Sp!=null)O=O+(" o:opacity2='"+this.Sp+"'");}O=O+"/>";return O;};b.zl=function(i,f){i[f]=this.paint();return f+1;};b.Jd=function(){return (this.yY==1||this.yY==null)&&(!this.n8||this.n8=="solid");};c.valueOf=function(l){if(jsx3.util.strEmpty(l))return null;if(l instanceof c)return l;var
pc=l.toString().split(/\s+/);return new
c(pc[0],pc[1]);};b.Qc=function(o){return false;};});jsx3.Class.defineClass("jsx3.vector.Group",jsx3.vector.Tag,null,function(i,k){k.init=function(p,s,d,a){this.jsxsuper(i.en,p,s,d,a);};i.en="group";k.Qc=function(a){return a instanceof i||a instanceof jsx3.vector.Shape;};});jsx3.Class.defineClass("jsx3.vector.Shape",jsx3.vector.Tag,null,function(l,g){var
xc=jsx3.html.Tag;var
Ac=jsx3.vector;g.init=function(s,f,c,a,d){this.jsxsuper(s!=null?s:l.en,f,c,a,d);this.bf=null;this.mp=null;};g.getPath=function(){return this.getProperty("path");};g.setPath=function(b){this.setProperty("path",b);};g.dl=function(o,n,f){this.B7((f?"t":"m")+" "+o+" "+n);return this;};g.pj=function(i,h,s){this.B7((s?"r":"l")+" "+i+" "+h);return this;};g.Aj=function(n,m,e,d,p,k,c,j,r){this.B7((r?"wa":"at")+" "+(n-e)+" "+(m-d)+" "+(n+e)+" "+(m+d)+" "+p+" "+k+" "+c+" "+j);return this;};g.Bh=function(){this.B7("x");return this;};g.B7=function(o){var
v=this.getPath();if(!v)this.setPath(o);else this.setPath(v+" "+o);};l.en="shape";g.paintUpdate=function(){var
U=this.getChildren().concat();for(var
Fc=0;Fc<U.length;Fc++)if(typeof U[Fc]=="string")this.removeChild(U[Fc]);this.jsxsuper();this.setProperty("filled",this.getFill()==null?"false":null,"stroked",this.getStroke()==null?"false":null);if(this.bf!=null)if(this.bf.Jd()){this.setProperty("filled",this.bf.vv!=null?this.bf.vv?"true":"false":null,"fillcolor",this.bf.getColorHtml());}else{this.removeProperty("filled","fillcolor");this.appendChild(this.bf.paint());}if(this.mp!=null)if(this.mp.Jd()){var
mb=this.mp.getWidth();this.setProperty("stroked",this.mp.vv!=null?this.mp.vv?"true":"false":null,"strokecolor",this.mp.getColorHtml(),"strokeweight",mb!=null?Ac.Zj(mb):null);}else{this.removeProperty("stroked","strokecolor","strokeweight");this.appendChild(this.mp.paint());}};g.Qc=function(a){return a instanceof Ac.TextLine||a instanceof Ac.Fill||a instanceof Ac.Stroke||typeof a=="string";};g.setFill=function(f){this.bf=f;};g.setStroke=function(j){this.mp=j;};g.getFill=function(){return this.bf;};g.getStroke=function(){return this.mp;};});jsx3.Class.defineClass("jsx3.vector.Line",jsx3.vector.Shape,null,function(k,n){n.init=function(g,j,f,m,e,l){var
Lc=Math.max(g,Math.max(f,e))-Math.min(g,Math.min(f,e));var
Hc=Math.max(j,Math.max(m,l))-Math.min(j,Math.min(m,l));this.jsxsuper("line",g,j,Math.max(Lc,16),Math.max(Hc,16));this.PD=f;this.m7=m;this.uS=e;this.my=l;};n.pn=function(c,j,b,i){this.PD=c;this.m7=j;this.uS=b;this.my=i;var
U=this.getLeft();var
ic=this.getTop();var
Lc=Math.max(U,Math.max(c,b))-Math.min(U,Math.min(c,b));var
sc=Math.max(ic,Math.max(j,i))-Math.min(ic,Math.min(j,i));this.setWidth(Lc);this.setHeight(sc);};n.getX1=function(){return this.PD;};n.setX1=function(s){this.PD=s;};n.getY1=function(){return this.m7;};n.setY1=function(d){this.m7=d;};n.getX2=function(){return this.uS;};n.setX2=function(c){this.uS=c;};n.getY2=function(){return this.my;};n.setY2=function(i){this.my=i;};n.paintUpdate=function(){this.jsxsuper();this.removeProperty("coordsize");this.setProperty("from",jsx3.vector.Zk(this.PD,this.m7),"to",jsx3.vector.Zk(this.uS,this.my));};n.toString=function(){return "<line "+this.getId()+" {"+this.getX1()+","+this.getY1()+"} {"+this.getX2()+","+this.getY2()+"}/>";};});jsx3.Class.defineClass("jsx3.vector.Rectangle",jsx3.vector.Shape,null,function(r,i){i.init=function(p,s,d,a){this.jsxsuper("rect",p,s,d,a);};i.gl=function(p){this.Hp(p.getLeft(),p.getTop(),p.getWidth(),p.getHeight());};i.Hp=function(l,k,m,c){var
xb=Math.max(this.getLeft(),l);var
T=Math.max(this.getTop(),k);var
vc=Math.min(this.getWidth()-(xb-this.getLeft()),l+m-xb);var
Fb=Math.min(this.getHeight()-(T-this.getTop()),k+c-T);this.setDimensions(xb,T,vc,Fb);};i.paintUpdate=function(){this.jsxsuper();this.removeProperty("coordsize");};});jsx3.Class.defineClass("jsx3.vector.Oval",jsx3.vector.Shape,null,function(a,b){b.init=function(p,s,d,k){this.jsxsuper(a.en,p,s,d,k);};a.en="oval";b.paintUpdate=function(){this.jsxsuper();this.removeProperty("coordsize");};});jsx3.Class.defineClass("jsx3.vector.Polygon",jsx3.vector.Shape,null,function(r,o){o.init=function(k,n,q){this.jsxsuper("polyline",k,n);this.lV=null;this.Tq=q;this.ks=q!=null?q.join(" "):null;};o.pn=function(i){this.lV=i;this.Tq=null;this.ks=i!=null?i.join(" "):null;};o.Pg=function(b){this.lV=null;this.Tq=b;this.ks=b!=null?b.join(" "):null;};o.ih=function(q){this.lV=null;this.Tq=null;this.ks=q;};o.paintUpdate=function(){this.jsxsuper();this.setProperty("points",this.ks);};});jsx3.Class.defineClass("jsx3.vector.TextLine",jsx3.vector.Shape,[jsx3.html.FontTag],function(g,b){var
bc=jsx3.html.Tag;var
Ab=jsx3.app.Browser;var
G=jsx3.vector;b.init=function(f,m,e,l,h){var
Lc=Math.max(1,Math.max(f,e)-Math.min(f,e));var
Hc=Math.max(1,Math.max(m,l)-Math.min(m,l));this.jsxsuper(null,f,m,Lc,Hc);this.setProperty("path","m 0 0 l "+(e-f)+" "+(l-m));this.UU=new
bc(G.Yh,"textpath");this.UU.setProperty("on","true");this.h1=new
bc(G.Yh,"path");this.h1.setProperty("textpathok","true");this.oB=new
bc(G.Yh,"stroke");this.oB.setProperty("on","false");this.setText(h);};var
ac="UU";var
pb=jsx3.html.FontTag.jsxclass.getInstanceMethods();for(var
Sb=0;Sb<pb.length;Sb++){var
Ib=pb[Sb];b[Ib.getName()]=new
Function("return jsx3.html.FontTag.prototype."+Ib.getName()+".apply(this."+ac+", arguments);");}var
B=["getClassName","setClassName","setExtraStyles","setExtraStyles"];for(var
Sb=0;Sb<B.length;Sb++)b[B[Sb]]=new
Function("return jsx3.html.Tag.prototype."+B[Sb]+".apply(this."+ac+", arguments);");b.setColor=function(i){if(i!=null&&i!="")this.setFill(new
G.Fill(i));this.UU.setStyle("color",i);};b.getTextAlign=function(){return this.UU.getStyle("v-text-align");};b.setTextAlign=function(r){this.UU.setStyle("v-text-align",r);};b.getText=function(){return this.UU.getProperty("string");};b.setText=function(r){this.UU.setProperty("string",r);};b.Qc=function(h){var
H=h.getTagName();return this.jsxsuper(h)||H=="path"||H=="textpath"||H=="stroke";};b.paintUpdate=function(){var
Fb=null;if(this.getFill()==null){var
tb=this.getColor();if(!tb){if(Fb==null)Fb=Ab.getStyleClass("."+this.getClassName())||Number(0);if(Fb)tb=Fb.color;}this.setFill(new
G.Fill(tb||"#000000"));}if(!this.getTextAlign()){var
Ec=this.UU.getStyle("textAlign");if(Ec==null){if(Fb==null)Fb=Ab.getStyleClass("."+this.getClassName())||Number(0);if(Fb)Ec=Fb.textAlign;}if(Ec)this.setTextAlign(Ec);}this.jsxsuper();this.setProperty("filled",this.getFill()==null?"false":"true","stroked",this.getStroke()==null?null:"true");if(this.UU.getParent()==null)this.appendChild(this.UU);if(this.h1.getParent()==null)this.appendChild(this.h1);if(this.getStroke()==null){if(this.oB.getParent()==null)this.appendChild(this.oB);}else this.removeChild(this.oB);};});jsx3.Class.defineClass("jsx3.vector.LineGroup",jsx3.vector.Shape,null,function(n,m){m.init=function(p,s,d,a){this.jsxsuper(null,p,s,d,a);};m.bm=function(h,o,g,b){this.dl(h,o).pj(g,b);};m.me=function(o,c,d,l){this.dl(o,c).pj(d,l,true);};m.se=function(){this.setPath("");};});jsx3.Class.defineClass("jsx3.vector.RectangleGroup",jsx3.vector.Shape,null,function(h,r){r.init=function(p,s,d,a){this.jsxsuper(null,p,s,d,a);};r.uo=function(b,o,g,n){this.dl(b,o).pj(g,o).pj(g,n).pj(b,n).Bh();};r.em=function(o,c,q,m){this.dl(o,c).pj(q,0,true).pj(0,m,true).pj(-1*q,0,true).Bh();};r.lp=function(){this.setPath("");};});jsx3.Class.defineInterface("jsx3.chart.PointRenderer",null,function(i,b){var
L=jsx3.vector;b.render=jsx3.Method.newAbstract("x1","y1","x2","y2","fill","stroke");b.areaToRadius=jsx3.Method.newAbstract("area");i.CIRCLE=i.jsxclass.newInnerClass();i.CIRCLE.areaToRadius=function(g){return Math.sqrt(g/Math.PI);};i.CIRCLE.render=function(k,r,j,q,l,h){var
P=new
L.Oval(k,r,j-k,q-r);P.setFill(l);P.setStroke(h);return P;};i.CROSS=i.jsxclass.newInnerClass();i.CROSS.SJ=0.6;i.CROSS.areaToRadius=function(p){return Math.sqrt(p/(1-this.SJ/Math.SQRT2))/2;};i.CROSS.render=function(k,r,j,q,l,h){var
rc=j-k;var
mc=this.SJ;var
T=Math.round(rc*(1-mc)/2);var
jb=Math.round(rc*mc/2);var
vc=Math.round(rc-rc*(1-mc)/2);var
ib=Math.round(rc/2);var
Nc=new
L.Polygon(0,0,[k,r,k+T,r,k+ib,r+jb,k+vc,r,j,r,j,r+T,j-jb,r+ib,j,r+vc,j,q,j-T,q,j-ib,q-jb,j-vc,q,k,q,k,q-T,k+jb,q-ib,k,q-vc,k,r]);Nc.setFill(l);Nc.setStroke(h);return Nc;};i.DIAMOND=i.jsxclass.newInnerClass();i.DIAMOND.qP=1.2;i.DIAMOND.areaToRadius=function(n){return Math.sqrt(n)/2;};i.DIAMOND.render=function(a,h,s,g,r,o){var
t=(a+s)/2;var
Fb=(h+g)/2;var
Xb=(s-a)/this.qP;var
Pb=(g-h)/this.qP;var
gc=new
L.Rectangle(Math.round(t-Xb/2),Math.round(Fb-Pb/2),Math.round(Xb),Math.round(Pb));gc.setRotation(45);gc.setFill(r);gc.setStroke(o);return gc;};i.BOX=i.jsxclass.newInnerClass();i.BOX.areaToRadius=function(f){return Math.sqrt(i.DIAMOND.qP*i.DIAMOND.qP*f)/2;};i.BOX.render=function(l,s,k,r,m,j){var
J=new
L.Rectangle(l,s,k-l,r-s);J.setFill(m);J.setStroke(j);return J;};i.TRIANGLE=i.jsxclass.newInnerClass();i.TRIANGLE.areaToRadius=function(l){return Math.sqrt(2*l)/2;};i.TRIANGLE.render=function(d,k,a,h,c,s){var
Kb=Math.round((d+a)/2);var
E=new
L.Polygon(0,0,[Kb,k,a,h,d,h,Kb,k]);E.setFill(c);E.setStroke(s);return E;};});jsx3.chart.Renderers=jsx3.chart.PointRenderer;jsx3.chart.Renderers.Circle=jsx3.chart.PointRenderer.CIRCLE;jsx3.chart.Renderers.Cross=jsx3.chart.PointRenderer.CROSS;jsx3.chart.Renderers.Diamond=jsx3.chart.PointRenderer.DIAMOND;jsx3.chart.Renderers.Box=jsx3.chart.PointRenderer.BOX;jsx3.chart.Renderers.Triangle=jsx3.chart.PointRenderer.TRIANGLE;jsx3.require("jsx3.gui.Block");jsx3.Class.defineClass("jsx3.chart.ChartComponent",jsx3.gui.Block,null,function(n,q){var
oc=jsx3.gui.Event;var
nc=jsx3.gui.Interactive;var
Fb=jsx3.vector;var
zb=jsx3.chart;n.IM={};n.MASK_PROPS_NOEDIT={NN:false,SS:false,EE:false,WW:false,MM:false};n.MASK_PROPS_ALLEDIT={NN:true,SS:true,EE:true,WW:true,MM:true};n.MASK_PROPS_ALLEDITREL={NN:false,SS:true,EE:true,WW:false,MM:false};q.init=function(p){this.jsxsuper(p);this.Ts=null;this.kC=null;};q.getChart=function(){return this.findAncestor(function(i){return zb.Chart&&i instanceof zb.Chart;},true);};q.tf=function(){if(this.Ts==null)this.updateView();return this.Ts;};if(jsx3.CLASS_LOADER.VML){q.paint=function(){var
lc=zb.LOG_BENCH.isLoggable(jsx3.util.Logger.TRACE);if(this.Ts==null){if(lc)zb.LOG_BENCH.trace("paint() update view - "+this.getId());this.updateView();}if(lc)zb.LOG_BENCH.trace("paint() serializing - "+this.getId());var
z=this.Ts.paint();if(lc)zb.LOG_BENCH.trace("paint() done - "+this.getId());return z;};q.repaint=function(){this.updateView();var
Cb=this.jsxsuper();var
Ic=this.getChart();if(Ic!=null){var
P=Ic.getRendered();if(P!=null){var
Ub=P.style.zIndex;if(Ub==null)Ub=0;P.style.zIndex=Ub+1;P.style.zIndex=Ub;}}return Cb;};}else if(jsx3.CLASS_LOADER.SVG){q.isDomPaint=function(){return true;};q.paint=function(){throw new
jsx3.Exception();};q.paintDom=function(){if(this.Ts==null)this.updateView();return this.Ts.paintDom();};q.repaint=function(){this.updateView();return this.jsxsuper();};}q.doClone=function(p){this.Ts=null;this.kC=null;return this.jsxsuper(p);};q.updateView=function(){this.applyDynamicProperties();var
cc=null,N=null;if(this.Ts!=null){N=this.Ts;cc=N.getParent();}this.Ts=this.Tc().newInstance();this.Ts.setId(this.getId());this.Ts.setDimensions(this.getDimensions());this.Ts.setZIndex(this.getZIndex());this.Ts.setPosition(this.getRelativePosition()?"relative":"absolute");var
xb=this.getAttributes();for(var R in xb)this.Ts.setProperty(R,xb[R]);if(cc!=null)cc.replaceChild(this.Ts,N);if(N!=null)N.release();};q.Tc=function(){return Fb.Group.jsxclass;};q.th=function(p){if(p==null)p=this.Ts;var
mc={};if(this.getMenu()!=null)mc[oc.MOUSEUP]=true;if(this.hasEvent(nc.SELECT))mc[oc.CLICK]=true;if(this.hasEvent(nc.EXECUTE))mc[oc.DOUBLECLICK]=true;if(this.hasEvent(nc.SPYGLASS)){mc[oc.MOUSEOVER]="doSpyOver";mc[oc.MOUSEOUT]="doSpyOut";}this.qk(mc,p);};n.mx="Vi";if(jsx3.CLASS_LOADER.VML){q.qk=function(k,s){for(var
x=0;x<nc.Tk.length;x++){var
Eb=nc.Tk[x];var
P="on"+Eb;var
yc=[];var
Jc=this.getAttribute(P);if(Jc){yc.push(Jc.replace(/\"/g,"&quot;"));if(!Jc.match(/;\s*$/))yc.push(";");}var
O=k[Eb];if(O){if(typeof O!="string")O=nc.Sn[Eb];yc.push("jsx3.GO('"+this.getId()+"')."+n.mx+"(event,this,'"+O+"');");}if(yc.length>0)s.setProperty(P,yc.join(""));}};}else if(jsx3.CLASS_LOADER.SVG)q.qk=function(h,p){var
fc=h[oc.DOUBLECLICK];for(var
cb=0;cb<nc.Tk.length;cb++){var
R=nc.Tk[cb];if(fc&&(R==oc.DOUBLECLICK||R==oc.CLICK))continue;var
Eb="on"+R;var
Gc=[];var
sc=this.getAttribute(Eb);if(sc){Gc.push(sc.replace(/\"/g,"&quot;"));if(!sc.match(/;\s*$/))Gc.push(";");}var
Zb=h[R];if(Zb){if(typeof Zb!="string")Zb=nc.Sn[R];Gc.push("jsx3.GO('"+this.getId()+"')."+n.mx+"(evt,this,'"+Zb+"');");}if(Gc.length>0)p.setProperty(Eb,Gc.join(""));}if(fc){var
z="";var
J=nc.Sn[oc.DOUBLECLICK];if(h[oc.CLICK]){var
Lc=nc.Sn[oc.CLICK];z="jsx3.GO('"+this.getId()+"')."+n.mx+"(evt,this,evt.detail%2==1?'"+Lc+"':'"+J+"');";}else z="if(evt.detail%2==0)jsx3.GO('"+this.getId()+"')."+n.mx+"(evt,this,'"+J+"');";p.setProperty("onclick",z);}};q.nh=function(b){var
ub=this.getBackgroundColor();if(ub!=null&&ub.match(/\S/)){var
t=b.getFirstChildOfType(Fb.Fill);if(t==null){t=new
Fb.Fill();b.setFill(t);}t.setColor(ub);if(typeof this.getAlpha=="function")t.setAlpha(this.getAlpha());}else b.setFill(null);};q.Ye=function(b){var
v=this.getBorderColor();if(v!=null&&v.match(/\S/)){var
vb=b.getFirstChildOfType(Fb.Stroke);if(vb==null){vb=new
Fb.Stroke();b.setStroke(vb);}vb.setColor(v);if(typeof this.getBorderAlpha=="function")vb.setAlpha(this.getBorderAlpha());if(typeof this.getBorderWidth=="function")vb.setWidth(this.getBorderWidth());}else b.setStroke(null);};q.Dd=function(b,g){this[b]=g;this["_"+b+"_eval"]=null;};q.Sm=function(a,e){if(e==null)e="object";var
Kc="_"+a+"_eval";if(!this[Kc]&&this[a])try{var
tb=this.eval("var f = "+this[a]+"; f;");this[Kc]=tb;if(typeof this[Kc]!=e){zb.LOG.error("error evaluating '"+a+"', "+this[Kc]+" is not of type "+e);this[Kc]=n.IM;}}catch(Nc){Nc=jsx3.NativeError.wrap(Nc);this[Kc]=n.IM;zb.LOG.error("error evaluating "+e+" field '"+a,Nc);}return this[Kc]!=n.IM?this[Kc]:null;};q.vd=function(s){return this.Sm(s,"function");};q.toString=function(){return "[ChartComponent '"+this.getName()+"']";};q.tm=function(r,a){if(this.kC==null)this.kC={};this.kC[r]=a;};q.pk=function(l){return this.kC!=null?this.kC[l]:null;};q.lk=function(f){if(this.kC!=null)delete this.kC[f];};q.getMaskProperties=function(){return n.MASK_PROPS_NOEDIT;};q.setLeft=function(l,b){this.jsxsuper(l,b);if(this.Ts!=null&&this.getRelativePosition()==jsx3.gui.Block.ABSOLUTE)this.Ts.setLeft(l);return this;};q.setTop=function(b,r){this.jsxsuper(b,r);if(this.Ts!=null&&this.getRelativePosition()==jsx3.gui.Block.ABSOLUTE)this.Ts.setTop(b);return this;};q.setWidth=function(k,i){this.jsxsuper(k);if(this.Ts!=null){this.Ts.setWidth(k);if(i)this.repaint();}return this;};q.setHeight=function(m,j){this.jsxsuper(m);if(this.Ts!=null){this.Ts.setHeight(m);if(j)this.repaint();}return this;};q.setRelativePosition=function(g,d){this.jsxsuper(g,d);if(this.Ts!=null)if(g==jsx3.gui.Block.RELATIVE){this.Ts.setPosition("relative");this.Ts.setLeft(0);this.Ts.setTop(0);}else{this.Ts.setPosition("absolute");this.Ts.setLeft(this.getLeft());this.Ts.setTop(this.getTop());}return this;};q.getMarginDimensions=function(){return this.Rf(this.getMargin());};q.getPaddingDimensions=function(){return this.Rf(this.getPadding());};q.Rf=function(j){if(j)if(typeof j=="number"){return [j,j,j,j];}else{var
hb=(""+j).split(/\D+/);if(hb[0]==="")hb.shift();if(hb.length>0&&hb[hb.length]==="")hb.pop();if(hb.length>=4){return [parseInt(hb[0]),parseInt(hb[1]),parseInt(hb[2]),parseInt(hb[3])];}else if(hb.length>=1){var
kc=parseInt(hb[0]);return [kc,kc,kc,kc];}}return [0,0,0,0];};q.getCanSpy=function(){return true;};n.getVersion=function(){return zb.sj;};});jsx3.require("jsx3.chart.ChartComponent");jsx3.Class.defineClass("jsx3.chart.ChartLabel",jsx3.chart.ChartComponent,null,function(j,p){var
mc=jsx3.vector;j.DEFAULT_WIDTH=100;j.ROTATION_NORMAL=0;j.ROTATION_CW=90;j.ROTATION_CCW=270;p.init=function(h,m){this.jsxsuper(h);this.jsxtext=m;this.alpha=null;this.borderStroke=null;this.preferredWidth=null;this.preferredHeight=null;this.labelRotation=0;};p.getText=function(){return this.jsxtext;};p.setText=function(e){this.jsxtext=e;};p.getPreferredWidth=function(){if(this.preferredWidth!=null){return this.preferredWidth;}else if(this.isRotated()){return this.lT();}else{var
P=this.getPaddingDimensions();return j.DEFAULT_WIDTH+P[0]+P[2];}};p.setPreferredWidth=function(l){this.preferredWidth=l;};p.getPreferredHeight=function(){if(this.preferredHeight!=null){return this.preferredHeight;}else if(this.isRotated()){var
jb=this.getPaddingDimensions();return j.DEFAULT_WIDTH+jb[1]+jb[3];}else return this.lT();};p.setPreferredHeight=function(d){this.preferredHeight=d;};p.lT=function(){var
tb=this.getPaddingDimensions();var
Zb=this.getFontSize()!=null?this.getFontSize():10;return Math.round(Zb*1.5)+(this.isRotated()?tb[1]+tb[3]:tb[0]+tb[2]);};p.getAlpha=function(){return this.alpha;};p.setAlpha=function(r){this.alpha=r!=null?mc.Ud(r):null;};p.getBorderStroke=function(){return this.borderStroke;};p.setBorderStroke=function(f){this.borderStroke=f;};p.getLabelRotation=function(){return this.labelRotation;};p.setLabelRotation=function(m){this.labelRotation=m;};p.isRotated=function(){return this.labelRotation==90||this.labelRotation==270;};p.updateView=function(){this.jsxsuper();var
_=this.tf();var
ob=this.getWidth();var
tb=this.getHeight();var
I=this.getPaddingDimensions();this.th();var
W=new
mc.Rectangle(0,0,ob,tb);_.appendChild(W);this.nh(W);var
hc=W.getFill();var
Gc=mc.Stroke.valueOf(this.borderStroke);if(Gc!=null){W.setStroke(Gc);}else if(hc!=null&&(this.alpha==null||this.alpha==1))W.setStroke(new
mc.Stroke(hc.getColor()));var
Sb=0,ec=0,T=0,z=0;if(this.isRotated()){T=(z=Math.round(I[3]+(ob-I[1]-I[3])/2));if(this.labelRotation==90){ec=tb;}else Sb=tb;}else{Sb=(ec=Math.round(tb/2));T=0;z=ob;}var
M=new
mc.TextLine(T,Sb,z,ec,this.jsxtext);M.setColor(this.getColor());M.setClassName(this.getClassName());M.setFontFamily(this.jsxfontname);M.setFontWeight(this.jsxfontweight);M.setFontSize(this.jsxfontsize);M.setTextAlign(this.jsxtextalign);_.appendChild(M);};p.onResize=function(){var
ec=this.getParent();if(ec!=null)if(jsx3.chart.Axis&&ec instanceof jsx3.chart.Axis)this.getChart().repaint();else ec.repaint();};p.onSetChild=function(){return false;};p.onSetParent=function(k){return k instanceof jsx3.chart.ChartComponent;};p.toString=function(){return "[jsx3.chart.ChartLabel '"+this.getName()+"']";};j.getVersion=function(){return jsx3.chart.sj;};});jsx3.require("jsx3.chart.ChartComponent");jsx3.Class.defineClass("jsx3.chart.Axis",jsx3.chart.ChartComponent,null,function(k,q){var
dc=jsx3.vector;var
sc=dc.Stroke;var
hb=jsx3.chart;k.TICK_INSIDE="inside";k.TICK_OUTSIDE="outside";k.TICK_CROSS="cross";k.TICK_NONE="none";k.LABEL_HIGH="high";k.LABEL_LOW="low";k.LABEL_AXIS="axis";k.I0={inside:1,outside:1,cross:1};k.yL={axis:1,high:1,low:1};k.vO=1;k.Pt=2;k.Fx=4;k.JI=3;k.FC=7;k.A2=8;k.dK=6;k.BQ=5;k.tJ=[k.JI,k.Fx,k.Pt,k.vO,k.Pt,k.vO,k.JI,k.Fx,k.A2,k.dK,k.FC,k.BQ];k.tB=10;k.kY=50;k.uI=12;k.percent=function(s){return s+"%";};k.scientific=function(h,f){if(h==0)return "0";if(f==null)f=2;var
ub=h<0;h=Math.abs(h);var
Jb=Math.floor(Math.log(h)/Math.LN10);var
Dc=Jb!=0?h/Math.pow(10,Jb):h;Dc=Dc.toString();var
sb=Dc.indexOf(".");if(sb>=0)if(Dc.length-sb-1>f)Dc=Dc.substring(0,sb+1+f);return (ub?"-":"")+Dc+"e"+Jb;};q.init=function(c,e,p){this.jsxsuper(c);this.horizontal=e!=null?jsx3.Boolean.valueOf(e):null;this.primary=p!=null?jsx3.Boolean.valueOf(p):null;this.length=100;this.showAxis=jsx3.Boolean.TRUE;this.axisStroke="#000000";this.showLabels=jsx3.Boolean.TRUE;this.labelGap=3;this.labelRotation=0;this.labelPlacement="axis";this.tickLength=3;this.tickPlacement="outside";this.tickStroke="#000000";this.minorTickDivisions=4;this.minorTickLength=3;this.minorTickPlacement="none";this.minorTickStroke=null;this.labelFunction=null;this.labelClass=null;this.labelStyle=null;this.labelColor=null;this.displayWidth=null;};q.af=jsx3.Method.newAbstract("index");q.yf=jsx3.Method.newAbstract();q.Kk=jsx3.Method.newAbstract();q.ve=jsx3.Method.newAbstract();q.getHorizontal=function(){return this.horizontal;};q.setHorizontal=function(c){this.horizontal=c;};q.Fj=function(){return this.primary;};q.ki=function(o){this.primary=o;};q.getLength=function(){return this.length;};q.setLength=function(j){this.length=j;};q.getShowAxis=function(){return this.showAxis;};q.setShowAxis=function(l){this.showAxis=l;};q.getLabelFunction=function(){return this.vd("labelFunction");};q.setLabelFunction=function(n){this.Dd("labelFunction",n);};q.getAxisStroke=function(){return this.axisStroke;};q.setAxisStroke=function(l){this.axisStroke=l;};q.getShowLabels=function(){return this.showLabels;};q.setShowLabels=function(f){this.showLabels=f;};q.getLabelGap=function(){return this.labelGap;};q.setLabelGap=function(f){this.labelGap=f;};q.getLabelRotation=function(){return this.labelRotation;};q.setLabelRotation=function(o){this.labelRotation=o;};q.getLabelPlacement=function(){return this.labelPlacement;};q.setLabelPlacement=function(p){if(k.yL[p]){this.labelPlacement=p;}else throw new
jsx3.IllegalArgumentException("labelPlacement",p);};q.getTickLength=function(){return this.tickLength;};q.setTickLength=function(h){this.tickLength=h;};q.getTickPlacement=function(){return this.tickPlacement;};q.setTickPlacement=function(j){if(k.I0[j]||j=="none"){this.tickPlacement=j;}else throw new
jsx3.IllegalArgumentException("tickPlacement",j);};q.getTickStroke=function(){return this.tickStroke;};q.setTickStroke=function(s){this.tickStroke=s;};q.getMinorTickDivisions=function(){return this.minorTickDivisions;};q.setMinorTickDivisions=function(f){this.minorTickDivisions=f;};q.getMinorTickLength=function(){return this.minorTickLength;};q.setMinorTickLength=function(s){this.minorTickLength=s;};q.getMinorTickPlacement=function(){return this.minorTickPlacement;};q.setMinorTickPlacement=function(c){if(k.I0[c]||c=="none"){this.minorTickPlacement=c;}else throw new
jsx3.IllegalArgumentException("minorTickPlacement",c);};q.getMinorTickStroke=function(){return this.minorTickStroke;};q.setMinorTickStroke=function(j){this.minorTickStroke=j;};q.getLabelClass=function(){return this.labelClass;};q.setLabelClass=function(g){this.labelClass=g;};q.getLabelStyle=function(){return this.labelStyle;};q.setLabelStyle=function(a){this.labelStyle=a;};q.getLabelColor=function(){return this.labelColor;};q.setLabelColor=function(r){this.labelColor=r;};q.getDisplayWidth=function(){if(this.displayWidth!=null){return this.displayWidth;}else return this.horizontal?k.uI:k.kY;};q.setDisplayWidth=function(l){this.displayWidth=l;};q.updateView=function(){this.jsxsuper();var
x=this.tf();var
Hc=this.getWidth();var
vc=this.getHeight();var
Vb=this.getOpposingAxis();if(Vb==null)return;var
Mc=this.b4(Vb);this.th();if(this.showAxis){var
Bc=new
dc.Line(0,0,0,0,0,0);x.appendChild(Bc);var
T=sc.valueOf(this.axisStroke);if(T==null)T=new
sc();Bc.setStroke(T);if(this.horizontal)Bc.pn(0,Mc,this.length,Mc);else Bc.pn(Mc,0,Mc,this.length);}var
Fb=this.yf();if(k.I0[this.tickPlacement]&&this.tickLength>0){var
D=new
dc.LineGroup(0,0,Hc,vc);x.appendChild(D);var
T=sc.valueOf(this.tickStroke);D.setStroke(T);var
B=this.Q3(this.tickPlacement,this.tickLength);var
O=B[0];var
J=Mc+B[1];this.ME(D,Fb,J,O);}if(k.I0[this.minorTickPlacement]&&this.minorTickLength>0){var
wc=new
dc.LineGroup(0,0,Hc,vc);x.appendChild(wc);var
T=sc.valueOf(this.minorTickStroke);wc.setStroke(T);var
B=this.Q3(this.minorTickPlacement,this.minorTickLength);var
O=B[0];var
J=Mc+B[1];var
X=0;for(var
M=0;M<Fb.length;M++){var
cc=this.ff(Fb,M);this.ME(wc,cc,J,O);X=Fb[M];}if(X<this.length){var
cc=this.ff(Fb,Fb.length);this.ME(wc,cc,J,O);}}var
gb=this.pq(Mc);var
lc=this.getAxisTitle();if(lc!=null&&lc.getDisplay()!=jsx3.gui.Block.DISPLAYNONE){var
kb=gb[5];var
Ib=this.horizontal&&this.primary||!this.horizontal&&!this.primary?0:-1;if(this.horizontal){var
Gc=kb+Ib*lc.getPreferredHeight();lc.setDimensions(0,Gc,this.length,lc.getPreferredHeight());}else{var
L=kb+Ib*lc.getPreferredWidth();lc.setDimensions(L,0,lc.getPreferredWidth(),this.length);}lc.updateView();x.appendChild(lc.tf());}if(this.showLabels){var
xc=this.Pi();var
tb=new
dc.Group(0,0,Hc,vc);x.appendChild(tb);var
R=gb[0];var
ub=gb[1];var
Ib=gb[2];this._jsxMY=null;for(var
M=0;M<xc.length;M++){var
Ob=xc[M];var
Lc=null;if(this.horizontal){var
jc=M>0?(xc[M-1]+xc[M])/2:null;var
bb=M<xc.length-1?(xc[M+1]+xc[M])/2:null;if(bb==null&&jc!=null)bb=2*xc[M]-jc;else if(jc==null&&bb!=null)jc=2*xc[M]-bb;if(bb==null){jc=xc[M]-50;bb=xc[M]+50;}Lc=Math.round(bb-jc);}else Lc=this.getDisplayWidth()-this.k4()-this.labelGap;if(this.horizontal){var
Wb=Math.round(Ob-Lc/2);var
Jb=ub+Ib*Math.round(k.tB/2);this.GJ(tb,Wb,Jb,Wb+Lc,Jb,this.YD(M));}else{var
Wb=Ib==1?ub:ub-Lc;this.GJ(tb,Wb,Ob,Wb+Lc,Ob,this.YD(M));}}}};q.GJ=function(s,a,h,p,g,d){if(!(d&&d.toString().match(/\S/)))return;var
yc=new
dc.TextLine(a,h,p,g,d);yc.setClassName(this.labelClass);yc.setExtraStyles(this.labelStyle);yc.setColor(this.labelColor);s.appendChild(yc);};q.YD=function(p){var
Zb=this.af(p);var
J=this.getLabelFunction();return J!=null?J.call(null,Zb):Zb!=null?Zb.toString():"";};q.k4=function(){var
kc=this.tickPlacement=="outside"||this.tickPlacement=="cross"?this.tickLength:0;var
sb=this.minorTickPlacement=="outside"||this.minorTickPlacement=="cross"?this.minorTickLength:0;return Math.max(kc,sb);};q.b4=function(d){if(d==null){d=this.getOpposingAxis();if(d==null)return 0;}if(d.Kk())return d.getCoordinateFor(0);else if(this.primary)return this.horizontal?d.getLength():0;else return this.horizontal?0:d.getLength();};q.Q3=function(l,i){var
mb=0;if(l=="cross"){mb=-1*i;i=i*2;}else{var
v=0;if(this.horizontal)v++;if(this.primary)v++;if(l=="inside")v++;if(v%2==1)mb=-1*i;}return [i,mb];};q.pq=function(b){var
I=this.getOpposingAxis();if(b==null)b=this.b4(I);var
tb=0;if(this.horizontal)tb=tb|1;if(this.primary)tb=tb|2;if(this.labelPlacement=="low")tb=tb|4;else if(this.labelPlacement=="axis")tb=tb|8;var
wb=k.tJ[tb];var
Zb=0;var
H=0;if(this.tickPlacement=="outside"||this.tickPlacement=="cross")Zb=this.tickLength;if(this.tickPlacement=="inside"||this.tickPlacement=="cross")H=this.tickLength;if(this.minorTickPlacement=="outside"||this.minorTickPlacement=="cross")Zb=Math.max(Zb,this.minorTickLength);if(this.minorTickPlacement=="inside"||this.minorTickPlacement=="cross")H=Math.max(H,this.minorTickLength);var
fb=null,S=null,Jc=null;switch(wb){case k.vO:case k.JI:S=-1;fb=-this.labelGap;fb=fb-Math.max(0,Zb-b);break;case k.Pt:case k.Fx:S=1;fb=I.getLength()+this.labelGap;fb=fb+Math.max(0,Zb+b-I.getLength());break;case k.FC:case k.dK:S=-1;fb=b-this.labelGap-Zb;break;case k.A2:case k.BQ:S=1;fb=b+this.labelGap+Zb;break;default:hb.LOG.error("bad placement value: "+wb);}if(this.showLabels){if(this.horizontal)Jc=fb+S*k.tB;else Jc=fb+S*this.getDisplayWidth();}else Jc=fb;if(this.horizontal&&this.primary||!this.horizontal&&!this.primary){Jc=Math.max(Jc,I.getLength());}else Jc=Math.min(Jc,0);return [wb,fb,S,Zb,H,Jc];};q.qh=function(){var
A=0,zb=0;var
jb=this.getOpposingAxis();if(jb==null)return [0,0];var
ec=this.b4(jb);var
oc=this.pq(ec);var
Nc=this.getAxisTitle();var
rb=oc[1];var
xb=oc[2];var
kc=oc[3];var
V=oc[4];if(this.showLabels)if(this.horizontal)rb=rb+xb*k.tB;else rb=rb+xb*this.getDisplayWidth();if(rb<0){A=-rb;}else if(rb>jb.getLength())zb=rb-jb.getLength();if(V>this.length-ec)zb=Math.max(zb,V+this.length-ec);if(kc>-ec)A=Math.max(A,kc-ec);if(Nc!=null&&Nc.getDisplay()!=jsx3.gui.Block.DISPLAYNONE)if(this.horizontal)zb=zb+Nc.getPreferredHeight();else A=A+Nc.getPreferredWidth();return [A,zb];};q.ME=function(l,o,c,s){if(this.horizontal){for(var
Ec=0;Ec<o.length;Ec++)l.me(o[Ec],c,0,s);}else for(var
Ec=0;Ec<o.length;Ec++)l.me(c,o[Ec],s,0);};q.Pi=function(){return this.yf();};q.ff=function(f,j){var
x=[];if(j==0){return [];}else if(j==f.length){return [];}else{var
t=f[j-1];var
kc=f[j];for(var
fc=1;fc<this.minorTickDivisions;fc++)x.push(Math.round(t+fc/this.minorTickDivisions*(kc-t)));}return x;};q.getAxisTitle=function(){return hb.ChartLabel?this.getFirstChildOfType(hb.ChartLabel):null;};q.getOpposingAxis=function(){var
F=this.getChart();if(F==null)return null;if(this.horizontal){if(this.primary){return F.getPrimaryYAxis();}else return F.getSecondaryYAxis();}else if(this.primary){return F.getPrimaryXAxis();}else return F.getSecondaryXAxis();};q.onSetChild=function(f){if((hb.ChartLabel&&f instanceof hb.ChartLabel)&&this.getAxisTitle()==null){f.setLabelRotation(this.horizontal?0:270);return true;}return false;};q.onSetParent=function(b){return hb.Chart&&b instanceof hb.Chart;};q.toString=function(){return "[Axis '"+this.getName()+"']";};k.getVersion=function(){return hb.sj;};});jsx3.require("jsx3.chart.ChartComponent","jsx3.chart.PointRenderer");jsx3.Class.defineClass("jsx3.chart.Legend",jsx3.chart.ChartComponent,null,function(n,q){var
L=jsx3.vector;var
Sb=jsx3.chart;n.DEFAULT_WIDTH=100;n.DEFAULT_HEIGHT=100;n.jS=1;n.hD=3;n.N4=2;n.SHOW_SERIES=1;n.SHOW_CATEGORIES=2;n.kw=8;n.DR=6;q.init=function(k){this.jsxsuper(k);this.boxHeight=10;this.lineHeight=22;this.labelClass=null;this.labelStyle=null;this.backgroundFill=null;this.backgroundStroke=null;this.preferredWidth=null;this.preferredHeight=null;this.setMargin("10 10 10 4");this.setPadding("4 4 0 4");};q.getBoxHeight=function(){return this.boxHeight;};q.setBoxHeight=function(h){this.boxHeight=h;};q.getLineHeight=function(){return this.lineHeight;};q.setLineHeight=function(h){this.lineHeight=h;};q.getLabelClass=function(){return this.labelClass;};q.setLabelClass=function(j){this.labelClass=j;};q.getLabelStyle=function(){return this.labelStyle;};q.setLabelStyle=function(f){this.labelStyle=f;};q.getBackgroundFill=function(){return this.backgroundFill;};q.setBackgroundFill=function(g){this.backgroundFill=g;};q.getBackgroundStroke=function(){return this.backgroundStroke;};q.setBackgroundStroke=function(k){this.backgroundStroke=k;};q.getPreferredWidth=function(){return this.preferredWidth!=null?this.preferredWidth:n.DEFAULT_WIDTH;};q.setPreferredWidth=function(m){this.preferredWidth=m;};q.getPreferredHeight=function(){return this.preferredHeight!=null?this.preferredHeight:n.DEFAULT_HEIGHT;};q.setPreferredHeight=function(h){this.preferredHeight=h;};q.updateView=function(){this.jsxsuper();var
Nc=this.tf();this.th();var
Bb=this.getChart();var
Db=Bb.getLegendEntryType();var
nc=0;if(Db==1){nc=Bb.Cm().length;}else if(Db==2){var
Xb=Bb.bi();if(Xb!=null)nc=Xb.length;}var
wb=this.getLegendTitle();var
Hb=wb!=null&&wb.getDisplay()!=jsx3.gui.Block.DISPLAYNONE?wb.getPreferredHeight()+n.kw:0;var
Vb=this.getMarginDimensions();var
y=this.getPaddingDimensions();var
kb=this.getWidth()-Vb[1]-Vb[3];var
ab=Math.min(this.getHeight()-Vb[0]-Vb[2],Hb+this.lineHeight*nc+y[0]+y[2]);var
A=Vb[3];var
U=Math.max(Vb[0],Math.round((this.getHeight()-ab)/2));var
Ub=new
L.Group(A,U,kb,ab);Nc.appendChild(Ub);Ub.setZIndex(n.N4);if(this.backgroundFill||this.backgroundStroke)if(nc>0||wb!=null&&wb.getDisplay()!=jsx3.gui.Block.DISPLAYNONE){var
yb=new
L.Rectangle(A,U,kb,ab);yb.setZIndex(n.jS);Nc.appendChild(yb);var
ac=L.Fill.valueOf(this.backgroundFill);var
Lc=L.Stroke.valueOf(this.backgroundStroke);yb.setFill(ac);yb.setStroke(Lc);}var
ib=U+y[0];var
db=kb-y[1]-y[3];if(wb!=null&&wb.getDisplay()!=jsx3.gui.Block.DISPLAYNONE){wb.setDimensions(A+y[3],ib,db,wb.getPreferredHeight());wb.setZIndex(n.hD);wb.updateView();Nc.appendChild(wb.tf());ib=ib+Hb;}ib=ib-U;var
O=A+y[3]+this.boxHeight+n.DR;var
rb=db-this.boxHeight-n.DR;if(Db==1&&nc>0){var
oc=Bb.Cm();for(var
Ic=0;Ic<oc.length;Ic++){var
eb=oc[Ic].getLegendRenderer();var
E=A+y[3];var
ac=oc[Ic].Rk();var
Lc=oc[Ic].ck(ac);var
Z=eb.render(E,ib,E+this.boxHeight,ib+this.boxHeight,ac,Lc);Z.setId(this.getId()+"_b"+Ic);Ub.appendChild(Z);var
hc=this.vP(Ub,oc[Ic].getSeriesName(),this.labelClass,this.labelStyle,O,Math.round(ib+this.boxHeight/2),rb);ib=ib+this.lineHeight;this.th(Z,oc[Ic],null);this.th(hc,oc[Ic],null);}}else if(Db==2&&nc>0){var
Xb=Bb.bi();var
eb=Sb.PointRenderer.BOX;var
Lc=L.Stroke.valueOf(Bb.getSeriesStroke());for(var
Ic=0;Ic<Xb.length;Ic++){var
E=A+y[3];var
ac=Bb.eo(Xb[Ic],Ic);var
jb=Lc==null&&ac.Jd()?new
L.Stroke(ac.getColor()):Lc;var
Z=eb.render(E,ib,E+this.boxHeight,ib+this.boxHeight,ac,jb);Z.setId(this.getId()+"_b"+Ic);Ub.appendChild(Z);var
x=Bb.getCategoryField();var
Rb=x?Xb[Ic].getAttribute(x):"";var
hc=this.vP(Ub,Rb,this.labelClass,this.labelStyle,O,Math.round(ib+this.boxHeight/2),rb);ib=ib+this.lineHeight;this.th(Z,null,Ic);this.th(hc,null,Ic);}}};q.vP=function(d,r,i,m,e,a,c){var
oc=new
L.TextLine(e,a,c,a,r);oc.setClassName(i);oc.setExtraStyles(m);if(!oc.getTextAlign())oc.setTextAlign("left");d.appendChild(oc);return oc;};q.getLegendTitle=function(){return Sb.ChartLabel?this.getFirstChildOfType(Sb.ChartLabel):null;};q.onSetChild=function(d){return (Sb.ChartLabel&&d instanceof Sb.ChartLabel)&&this.getLegendTitle()==null;};q.onSetParent=function(k){return Sb.Chart&&k instanceof Sb.Chart;};q.onResize=function(){var
ub=this.getParent();if(ub!=null)ub.repaint();};q.toString=function(){return "[Legend '"+this.getName()+"']";};n.getVersion=function(){return Sb.sj;};q.th=function(c,i,g){if(c==null)c=this.tf();if(i!=null)c.setProperty("seriesId",i.getId());if(g!=null)c.setProperty("recordIndex",g);this.jsxsuper(c);};q.Th=function(j,o){var
Y=o.getAttribute("seriesId");var
tc=o.getAttribute("recordIndex");this.doEvent(jsx3.gui.Interactive.SELECT,this.cU(j,Y,tc));};q.gg=function(r,p){var
sc=p.getAttribute("seriesId");var
hc=p.getAttribute("recordIndex");this.doEvent(jsx3.gui.Interactive.EXECUTE,this.cU(r,sc,hc));};q.doSpyOver=function(k,b){var
z=b.getAttribute("seriesId");var
Bb=b.getAttribute("recordIndex");this.jsxsupermix(k,b,this.cU(k,z,Bb));};q.ZY=function(r,p){var
Q=p.getAttribute("seriesId");var
Tb=p.getAttribute("recordIndex");var
Bc;if(r.rightButton()&&(Bc=this.getMenu())!=null){var
ob=this.getServer().getJSXByName(Bc);if(ob!=null){var
sb=this.cU(r,Q,Tb);sb.objMENU=ob;var
Hb=this.doEvent(jsx3.gui.Interactive.MENU,sb);if(Hb!==false){if(Hb instanceof Object&&Hb.objMENU instanceof jsx3.gui.Menu)ob=Hb.objMENU;ob.showContextMenu(r,this);}}}};q.cU=function(o,p,m){var
oc={objEVENT:o};oc.objSERIES=p!=null?this.getServer().getJSXById(p):null;if(m!=null){oc.intINDEX=m;var
Lb=this.getChart().bi()[m];oc.strRECORDID=Lb?Lb.getAttribute("jsxid"):null;}else oc.intINDEX=oc.strRECORDID=null;return oc;};});jsx3.require("jsx3.chart.ChartComponent");jsx3.Class.defineClass("jsx3.chart.Series",jsx3.chart.ChartComponent,null,function(m,p){var
db=jsx3.gui.Interactive;var
Ac=jsx3.vector;var
T=jsx3.chart;p.init=function(r,n){this.jsxsuper(r);this.seriesName=n;this.usePrimaryX=jsx3.Boolean.TRUE;this.usePrimaryY=jsx3.Boolean.TRUE;this.stroke=null;this.fill=null;this.fillGradient=null;this.tooltipFunction=null;};p.getSeriesName=function(){return this.seriesName;};p.setSeriesName=function(b){this.seriesName=b;};p.getUsePrimaryX=function(){return this.usePrimaryX;};p.setUsePrimaryX=function(l){this.usePrimaryX=l;};p.getUsePrimaryY=function(){return this.usePrimaryY;};p.setUsePrimaryY=function(d){this.usePrimaryY=d;};p.setTooltipFunction=function(b){this.Dd("tooltipFunction",b);};p.getTooltipFunction=function(){return this.vd("tooltipFunction");};p.getIndex=function(){var
nb=this.getChart();return nb!=null?nb.getSeriesIndex(this):-1;};p.getStroke=function(){return this.stroke;};p.setStroke=function(r){this.stroke=r;};p.getFill=function(){return this.fill;};p.setFill=function(g){this.fill=g;};p.getFillGradient=function(){return this.fillGradient;};p.setFillGradient=function(q){this.fillGradient=q;};p.getXAxis=function(){var
hc=this.getChart();if(hc!=null)return this.usePrimaryX?hc.getPrimaryXAxis():hc.getSecondaryXAxis();return null;};p.getYAxis=function(){var
cc=this.getChart();if(cc!=null)return this.usePrimaryY?cc.getPrimaryYAxis():cc.getSecondaryYAxis();return null;};p.Zg=function(){var
sb=Math.max(this.getIndex(),0)%T.Chart.DEFAULT_FILLS.length;return T.Chart.DEFAULT_FILLS[sb];};p.yj=function(){var
yb=Math.max(this.getIndex(),0)%T.Chart.DEFAULT_FILLS.length;if(T.Chart.DEFAULT_STROKES[yb]==null){var
Cc=this.Zg();T.Chart.DEFAULT_STROKES[yb]=new
Ac.Stroke(Cc.getColor(),1,Cc.getAlpha());}return T.Chart.DEFAULT_STROKES[yb];};p.Rk=function(){var
_=this.fill?Ac.Fill.valueOf(this.fill):this.Zg();if(_!=null)_=T.addGradient(_,this.fillGradient);return _;};p.ck=function(h){if(this.stroke){return Ac.Stroke.valueOf(this.stroke);}else if(this.getColorFunction()!=null){return null;}else if(h!=null&&h.Jd()){return new
Ac.Stroke(h.getColor());}else if(!this.fill)return this.yj(h);else return null;};p.getColorFunction=function(){return this.vd("colorFunction");};p.setColorFunction=function(k){this.Dd("colorFunction",k);};p.getLegendRenderer=function(){return T.PointRenderer.BOX;};p.getLabel=function(){return T.ChartLabel?this.getFirstChildOfType(T.ChartLabel):null;};p.onSetChild=function(f){return (T.ChartLabel&&f instanceof T.ChartLabel)&&this.getLabel()==null;};p.onSetParent=function(c){return T.Chart&&c instanceof T.Chart;};p.th=function(k,r,h){if(k==null)k=this.tf();if(h!=null)k.setProperty("strRecordId",h);if(r!=null)k.setProperty("recordIndex",r);this.jsxsuper(k);};p.Th=function(l,a){var
Sb=a.getAttribute("recordIndex");var
u=a.getAttribute("strRecordId");this.doEvent(jsx3.gui.Interactive.SELECT,{objEVENT:l,intINDEX:Sb,strRECORDID:u});};p.gg=function(e,h){var
tc=h.getAttribute("recordIndex");var
E=h.getAttribute("strRecordId");this.doEvent(jsx3.gui.Interactive.EXECUTE,{objEVENT:e,intINDEX:tc,strRECORDID:E});};p.doSpyOver=function(j,c){var
y=c.getAttribute("recordIndex");var
V=c.getAttribute("strRecordId");this.jsxsupermix(j,c,{objEVENT:j,intINDEX:y,strRECORDID:V});};p.ZY=function(h,e){var
kb=e.getAttribute("recordIndex");var
sc=e.getAttribute("strRecordId");var
nb;if(h.rightButton()&&(nb=this.getMenu())!=null){var
Wb=this.getServer().getJSXByName(nb);if(Wb!=null){var
U={objEVENT:h,objMENU:Wb,intINDEX:kb,strRECORDID:sc};var
Eb=this.doEvent(db.MENU,U);if(Eb!==false){if(Eb instanceof Object&&Eb.objMENU instanceof jsx3.gui.Menu)Wb=Eb.objMENU;Wb.showContextMenu(h,this,kb);}}}};p.toString=function(){return "[Series '"+this.getName()+"']";};m.getVersion=function(){return T.sj;};});jsx3.require("jsx3.chart.ChartComponent","jsx3.xml.Cacheable","jsx3.chart.Series");jsx3.Class.defineClass("jsx3.chart.Chart",jsx3.chart.ChartComponent,[jsx3.xml.Cacheable,jsx3.xml.CDF],function(d,f){var
_=jsx3.vector;var
lc=_.Fill;var
M=jsx3.chart;d.g_=1;d.N4=2;d.ZINDEX_DATA=10;d.YG=990;d.hD=1000;d.Dz=20;d.DEFAULT_FILLS=[new
lc(3381708,1),new
lc(16763904,1),new
lc(10079334,1),new
lc(13408563,1),new
lc(13421772,1),new
lc(13382502,1),new
lc(16751103,1),new
lc(6710886,1)];d.DEFAULT_STROKES=[];d.PART_LEGEND=1<<0;d.jK={top:1,right:1,bottom:1,left:1};f.init=function(a,e,h,o,i){this.jsxsuper(a);this.setDimensions(e,h,o,i);this.titlePlacement="top";this.legendPlacement="right";this.dataPadding=10;this.borderColor="#999999";this.borderWidth=1;this.borderAlpha=1;this.alpha=1;this.setRelativePosition(jsx3.gui.Block.RELATIVE);};f.getTitlePlacement=function(){return this.titlePlacement;};f.setTitlePlacement=function(r){if(d.jK[r]){this.titlePlacement=r;}else throw new
jsx3.IllegalArgumentException("titlePlacement",r);};f.getLegendPlacement=function(){return this.legendPlacement;};f.setLegendPlacement=function(l){if(d.jK[l]){this.legendPlacement=l;}else throw new
jsx3.IllegalArgumentException("legendPlacement",l);};f.getDataPadding=function(){return this.dataPadding;};f.setDataPadding=function(a){this.dataPadding=a;};f.getBorderColor=function(){return this.borderColor;};f.setBorderColor=function(l){this.borderColor=l;};f.getBorderWidth=function(){return this.borderWidth;};f.setBorderWidth=function(h){this.borderWidth=h;};f.getBorderAlpha=function(){return this.borderAlpha;};f.setBorderAlpha=function(m){this.borderAlpha=m;};f.getAlpha=function(){return this.alpha;};f.setAlpha=function(o){this.alpha=o!=null?_.Ud(o):null;};f.wg=function(){return this.pk("Jl");};f.bi=function(){return this.pk("No");};f.uO=function(e){if(e!=null){this.tm("No",e.selectNodes("/data/record").toArray());}else this.lk("No");};f.getSeries=function(){return this.getDescendantsOfType(M.Series);};f.Cm=function(){return this.findDescendants(function(s){return s instanceof M.Series&&s.getDisplay()!=jsx3.gui.Block.DISPLAYNONE;},false,true,false,false);};f.getSeriesIndex=function(o){var
Cb=this.getSeries();for(var
Cc=0;Cc<Cb.length;Cc++)if(o==Cb[Cc])return Cc;return -1;};f.getChartTitle=function(){return M.ChartLabel?this.getFirstChildOfType(M.ChartLabel):null;};f.getLegend=function(){return M.Legend?this.getFirstChildOfType(M.Legend):null;};f.ad=function(){return false;};f.zm=jsx3.Method.newAbstract("series");f.getLegendEntryType=function(){jsx3.require("jsx3.chart.Legend");return 1;};f.kk=function(q,h){var
bc=this.bi();if(bc==null)return null;var
Kb=new
Array(bc.length);for(var
gb=0;gb<bc.length;gb++){Kb[gb]=0;for(var
fc=0;fc<q.length;fc++){var
ob=q[fc][h](bc[gb]);if(ob!=null)Kb[gb]+=Math.abs(ob);}}return Kb;};f.Oh=function(o,j,h){var
P=this.bi();if(P==null)return null;var
E=new
Array(o.length);for(var
zb=0;zb<o.length;zb++){E[zb]=0;for(var
hc=0;hc<P.length;hc++){var
oc=o[zb][j](P[hc]);if(oc!=null&&(oc>=0||!h))E[zb]+=Math.abs(oc);}}return E;};f.Tc=function(){return _.Canvas.jsxclass;};f.updateView=function(){this.jsxsuper();var
ub=this.tf();var
pc=this.getLeft();var
sc=this.getTop();var
Mb=this.getWidth();var
zc=this.getHeight();if(isNaN(Mb)||isNaN(zc)){var
hb=this.getParent().Ln(this);if(Mb.toString().indexOf("%")>=0)Mb=Math.round(hb.parentwidth*parseFloat(Mb)/100);if(zc.toString().indexOf("%")>=0)zc=Math.round(hb.parentheight*parseFloat(zc)/100);ub.setWidth(Mb);ub.setHeight(zc);}var
Ic=this.getXML();this.uO(Ic);var
dc=new
_.Rectangle(0,0,Mb,zc);ub.appendChild(dc);dc.setZIndex(d.g_);this.nh(dc);this.Ye(dc);var
z=this.getPaddingDimensions();var
vc=this.borderWidth!=null?this.borderWidth:1;Mb=Mb-z[1]-z[3]-2*vc;zc=zc-z[0]-z[2]-2*vc;var
A=new
_.Group(z[3]+vc,z[0]+vc,Mb,zc);ub.appendChild(A);A.setZIndex(d.N4);var
uc=this.getChartTitle();if(uc!=null&&uc.getDisplay()!=jsx3.gui.Block.DISPLAYNONE){var
Sb=M.splitBox(0,0,Mb,zc,this.titlePlacement,uc.getPreferredWidth(),uc.getPreferredHeight());uc.setDimensions(Sb[0][0],Sb[0][1],Sb[0][2],Sb[0][3]);uc.setZIndex(d.hD);uc.updateView();A.appendChild(uc.tf());sc=Sb[1][0];pc=Sb[1][1];Mb=Sb[1][2];zc=Sb[1][3];}else{sc=0;pc=0;}var
y=new
_.Group();this.tm("Jl",y);A.appendChild(y);var
Y=this.getLegend();if(Y!=null&&Y.getDisplay()!=jsx3.gui.Block.DISPLAYNONE){var
Sb=M.splitBox(sc,pc,Mb,zc,this.legendPlacement,Y.getPreferredWidth(),Y.getPreferredHeight());Y.setDimensions(Sb[0][0],Sb[0][1],Sb[0][2],Sb[0][3]);Y.setZIndex(d.YG);Y.updateView();A.appendChild(Y.tf());y.setDimensions(Sb[1][0],Sb[1][1],Sb[1][2],Sb[1][3]);}else y.setDimensions(sc,pc,Mb,zc);var
qc=jsx3.html.BlockTag.Rf(this.dataPadding);var
fc=y.getDimensions();y.setDimensions(fc[0]+qc[3],fc[1]+qc[0],fc[2]-qc[1]-qc[3],fc[3]-qc[0]-qc[2]);this.th();var
S=this.Cm();for(var
Ec=0;Ec<S.length;Ec++){var
I=this.ad()?S.length-Ec:Ec;S[Ec].setZIndex(d.Dz+I);}};f.repaintParts=function(b){if(b&d.PART_LEGEND){var
F=this.getLegend();if(F!=null)F.repaint();}};f.toString=function(){return "[Chart '"+this.getName()+"']";};f.onSetChild=function(c){if(M.Legend&&c instanceof M.Legend){if(this.getLegend()!=null){M.LOG.info("can't add legend "+c+" because chart already has a legend");return false;}}else if(M.ChartLabel&&c instanceof M.ChartLabel){if(this.getChartTitle()!=null){M.LOG.info("can't add title "+c+" because chart already has a title");return false;}}else if(M.Series&&c instanceof M.Series){if(!this.zm(c)){M.LOG.info("can't add series "+c+" because it isn't of valid type for "+this);return false;}}else return false;return true;};f.redrawRecord=function(){this.repaint();};f.getMaskProperties=function(){return this.getRelativePosition()==jsx3.gui.Block.ABSOLUTE?M.ChartComponent.MASK_PROPS_ALLEDIT:M.ChartComponent.MASK_PROPS_ALLEDITREL;};f.onDestroy=function(b){this.jsxsuper(b);this.onDestroyCached(b);};f.zj=function(p){if(this.getParent()&&(p==null||isNaN(p.parentwidth)||isNaN(p.parentheight))){p=this.getParent().Ln(this);}else if(p==null)p={};var
Zb=this.getRelativePosition()!=jsx3.gui.Block.ABSOLUTE;var
Ab=Zb?null:this.getLeft();var
cc=Zb?null:this.getTop();p.boxtype=Zb?"relativebox":"box";p.tagname="span";if(p.left==null&&Ab!=null)p.left=Ab;if(p.top==null&&cc!=null)p.top=cc;p.width=this.getWidth();p.height=this.getHeight();return new
jsx3.gui.Painted.Box(p);};f.Vd=function(n,k,q){if(n.width==null&&n.height==null){this.Qh(n,k,q,3);}else{var
Fc=this.getWidth();var
Kc=this.getHeight();if(Fc.toString().indexOf("%")>=0||Kc.toString().indexOf("%")>=0){Fc=Math.round(n.parentwidth*parseFloat(Fc)/100);Kc=Math.round(n.parentheight*parseFloat(Kc)/100);var
Jc=this.tf();if(k!=null&&(Fc!=Jc.getWidth()||Kc!=Jc.getHeight())&&Fc>0&&Kc>0)q.addRepaint(this);}}};d.getVersion=function(){return M.sj;};});jsx3.require("jsx3.chart.Chart","jsx3.chart.Axis","jsx3.chart.GridLines");jsx3.Class.defineClass("jsx3.chart.CartesianChart",jsx3.chart.Chart,null,function(g,b){var
vb=jsx3.chart;var
Zb=vb.Chart;var
Tb=vb.GridLines;var
qb=vb.Axis;g.XPRIMARY_FILTER=function(l){return l instanceof qb&&l.Fj()&&l.getHorizontal();};g.XSECONDARY_FILTER=function(c){return c instanceof qb&&!c.Fj()&&c.getHorizontal();};g.YPRIMARY_FILTER=function(n){return n instanceof qb&&n.Fj()&&!n.getHorizontal();};g.YSECONDARY_FILTER=function(m){return m instanceof qb&&!m.Fj()&&!m.getHorizontal();};g.ZINDEX_GRIDLINES=Zb.ZINDEX_DATA+1;g.ZINDEX_GRIDLINES_FOREGROUND=Zb.ZINDEX_DATA+90;g.ZINDEX_AXIS=Zb.ZINDEX_DATA+100;g.PART_GRIDLINES=1<<8;b.init=function(c,j,m,d,k){this.jsxsuper(c,j,m,d,k);};b.getGridLines=function(){return Tb?this.getDescendantsOfType(Tb):[];};b.Xi=function(l,r){var
Qb=[];var
Gc=r?this.Cm():this.getSeries();for(var
w=0;w<Gc.length;w++)if(l.getHorizontal()&&l.Fj()==Gc[w].getUsePrimaryX()||!l.getHorizontal()&&l.Fj()==Gc[w].getUsePrimaryY())Qb.push(Gc[w]);return Qb;};b.getPrimaryXAxis=function(){return this.findDescendants(g.XPRIMARY_FILTER,false,false,true);};b.getSecondaryXAxis=function(){return this.findDescendants(g.XSECONDARY_FILTER,false,false,true);};b.getPrimaryYAxis=function(){return this.findDescendants(g.YPRIMARY_FILTER,false,false,true);};b.getSecondaryYAxis=function(){return this.findDescendants(g.YSECONDARY_FILTER,false,false,true);};b.getRangeForAxis=function(p){var
I=this.Xi(p,true);return p.getHorizontal()?this.getXRange(I):this.getYRange(I);};b.getXRange=jsx3.Method.newAbstract("series");b.getYRange=jsx3.Method.newAbstract("series");b.getRangeForField=function(c,j){var
hb=this.bi();if(hb==null){vb.LOG.debug("no data provider for chart: "+this);return null;}var
ob=Number.NEGATIVE_INFINITY;var
Q=Number.POSITIVE_INFINITY;for(var
S=0;S<hb.length;S++){var
jb=hb[S];for(var
Y=0;Y<c.length;Y++){var
L=c[Y];var
Bb=L[j](jb);if(Bb!=null){Q=Math.min(Q,Bb);ob=Math.max(ob,Bb);}}}if(ob==Number.NEGATIVE_INFINITY||Q==Number.POSITIVE_INFINITY)return null;return [Q,ob];};b.getStackedRangeForField=function(m,l){var
nc=this.bi();if(nc==null){vb.LOG.debug("no data provider for chart: "+this);return null;}var
hc=Number.NEGATIVE_INFINITY;var
cb=Number.POSITIVE_INFINITY;for(var
Cc=0;Cc<nc.length;Cc++){var
ec=nc[Cc];var
O=0,Nb=0;for(var
N=0;N<m.length;N++){var
ic=m[N];var
Db=ic[l](ec);if(Db==null)continue;if(Db>=0)O=O+Db;else Nb=Nb+Db;}cb=Math.min(cb,Nb);hc=Math.max(hc,O);}if(hc==Number.NEGATIVE_INFINITY||cb==Number.POSITIVE_INFINITY)return null;return [cb,hc];};b.getStacked100RangeForField=function(p,i){var
I=this.bi();if(I==null){vb.LOG.debug("no data provider for chart: "+this);return null;}var
C=Number.NEGATIVE_INFINITY;var
X=Number.POSITIVE_INFINITY;for(var
ac=0;ac<I.length;ac++){var
y=I[ac];var
T=0,Ac=0,u=0;for(var
ec=0;ec<p.length;ec++){var
Z=p[ec];var
D=Z[i](y);if(D==null)continue;u=u+Math.abs(D);if(D>=0)T=T+D;else Ac=Ac+D;}var
Cc=u==0?0:100*Ac/u;var
lb=u==0?0:100*T/u;X=Math.min(X,Cc);C=Math.max(C,lb);}if(C==Number.NEGATIVE_INFINITY||X==Number.POSITIVE_INFINITY)return null;return [X,C];};b.getCombinedRange=function(f){var
Wb=Number.NEGATIVE_INFINITY;var
E=Number.POSITIVE_INFINITY;for(var
mb=0;mb<f.length;mb++)if(f[mb]!=null){E=Math.min(E,f[mb][0]);Wb=Math.max(Wb,f[mb][1]);}if(Wb==Number.NEGATIVE_INFINITY||E==Number.POSITIVE_INFINITY)return null;return [E,Wb];};b.updateView=function(){this.jsxsuper();var
Ab=this.wg();var
Ob=this.getPrimaryXAxis();var
Cc=this.getPrimaryYAxis();var
Dc=this.getSecondaryXAxis();var
ic=this.getSecondaryYAxis();var
zc=Ab.getWidth();var
z=Ab.getHeight();var
rb=Ab.getPaddingDimensions();var
Lb=null;for(var
ab=1;ab<=2;ab++){var
zb=null;if(ab==1){zb=[Dc!=null?Dc.getDisplayWidth():0,ic!=null?ic.getDisplayWidth():0,Ob!=null?Ob.getDisplayWidth():0,Cc!=null?Cc.getDisplayWidth():0];}else zb=this.getAxisMetrics(Dc,ic,Ob,Cc);Lb=[rb[3]+zb[3],rb[0]+zb[0],zc-(rb[3]+zb[3]+rb[1]+zb[1]),z-(rb[0]+zb[0]+rb[2]+zb[2])];this.prepareAxis(Ob,Lb[2]);this.prepareAxis(Cc,Lb[3]);this.prepareAxis(Dc,Lb[2]);this.prepareAxis(ic,Lb[3]);}var
L=this.getGridLines();for(var
ab=0;ab<L.length;ab++){var
T=L[ab];if(T.getDisplay()==jsx3.gui.Block.DISPLAYNONE)continue;T.setDimensions(Lb);T.setZIndex(T.getInForeground()?g.ZINDEX_GRIDLINES_FOREGROUND:g.ZINDEX_GRIDLINES);T.updateView();Ab.appendChild(T.tf());}this.updateAxisView(Ob,Lb[0],Lb[1]);this.updateAxisView(Cc,Lb[0],Lb[1]);this.updateAxisView(Dc,Lb[0],Lb[1]);this.updateAxisView(ic,Lb[0],Lb[1]);var
W=this.Cm();for(var
ab=0;ab<W.length;ab++)W[ab].setDimensions(Lb);};b.prepareAxis=function(l,k){if(l!=null){l.setLength(k);l.ve();}};b.updateAxisView=function(i,q,r){var
Gb=this.wg();if(i!=null){i.setDimensions(q,r,Gb.getWidth(),Gb.getHeight());i.setZIndex(g.ZINDEX_AXIS);i.updateView();Gb.appendChild(i.tf());}};b.getAxisMetrics=function(a,m,o,c){var
nc=0,v=0,C=0,ac=0;if(a!=null){var
Y=a.qh();v=Y[1];ac=Y[0];}if(m!=null){var
Y=m.qh();C=C+Y[0];nc=nc+Y[1];}if(o!=null){var
Y=o.qh();ac=Math.max(ac,Y[1]);v=Math.max(v,Y[0]);}if(c!=null){var
Y=c.qh();nc=Math.max(nc,Y[0]);C=Math.max(C,Y[1]);}return [v,C,ac,nc];};b.repaintParts=function(o){if(o&g.PART_GRIDLINES){var
Db=this.getGridLines();for(var
kb=0;kb<Db.length;kb++){var
B=Db[kb];if(B.getDisplay()==jsx3.gui.Block.DISPLAYNONE)continue;B.setZIndex(B.getInForeground()?g.ZINDEX_GRIDLINES_FOREGROUND:g.ZINDEX_GRIDLINES);B.repaint();}}this.jsxsuper(o);};b.onSetChild=function(q){if(Tb&&q instanceof Tb){return true;}else if(qb&&q instanceof qb){return true;}else return this.jsxsuper(q);};b.toString=function(){return "[CartesianChart '"+this.getName()+"']";};g.getVersion=function(){return vb.sj;};});