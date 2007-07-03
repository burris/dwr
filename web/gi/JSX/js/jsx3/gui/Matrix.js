/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.xml.Cacheable","jsx3.gui.Form","jsx3.gui.Block","jsx3.gui.Matrix.Column","jsx3.util.MessageFormat");jsx3.Class.defineClass("jsx3.gui.Matrix",jsx3.gui.Block,[jsx3.gui.Form,jsx3.xml.Cacheable,jsx3.xml.CDF],function(m,q){var
Qb=jsx3.util.Logger.getLogger(m.jsxclass.getName());var
gc=jsx3.gui.Event;var
Lb=jsx3.gui.Interactive;var
A=jsx3.xml.CDF;var
Yb=jsx3.gui.Block;var
yc=jsx3.gui.Painted.Box;m.NF=500;m._3=1;m.w6=150;m.AUTO_SCROLL_INTERVAL=50;m.SELECTION_BG="jsx:///images/matrix/select.gif";m.INSERT_BEFORE_IMG=jsx3.resolveURI("jsx:///images/matrix/insert_before.gif");m.APPEND_IMG=jsx3.resolveURI("jsx:///images/matrix/append.gif");m.FOCUS_STYLE="font-weight:bold";m.ICON_MINUS="jsx:///images/matrix/minus.gif";m.ICON_PLUS="jsx:///images/matrix/plus.gif";m.ICON="jsx:///images/matrix/file.gif";m.SORT_ASCENDING="ascending";m.SORT_DESCENDING="descending";m.SORT_DESCENDING_IMG=jsx3.resolveURI("jsx:///images/matrix/sort_desc.gif");m.SORT_ASCENDING_IMG=jsx3.resolveURI("jsx:///images/matrix/sort_asc.gif");m.MINIMUM_COLUMN_WIDTH=8;m.DEFAULT_HEADER_HEIGHT=20;m.AUTOROW_NONE=0;m.AUTOROW_LAST_ROW=1;m.AUTOROW_FIRST_ROW=2;m.W0=new
jsx3.util.MessageFormat('<xsl:call-template xmlns:xsl="http://www.w3.org/1999/XSL/Transform" name="{0}">\n  <xsl:with-param name="jsx_is_first_panel_row" select="$jsx_is_first_panel_row"/>\n  <xsl:with-param name="jsx_row_number" select="$jsx_row_number"/>\n  <xsl:with-param name="jsx_rowbg" select="$jsx_rowbg"/>\n  <xsl:with-param name="jsx_cdfkey" select="$jsx_cdfkey"/>\n  <xsl:with-param name="jsx_descendant_index" select="$jsx_descendant_index"/>\n</xsl:call-template>');m.UC=new
jsx3.util.MessageFormat("<xsl:when xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" test=\"$jsx_cell_value_template_id=''{0}''\">\n  <xsl:for-each select=\"//*[@jsxid=$jsx_record_context]\">\n    <xsl:call-template name=\"{0}\">\n    </xsl:call-template>\n  </xsl:for-each>\n</xsl:when>\n");m.sz=new
jsx3.util.MessageFormat("<xsl:template xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" name=\"{0}\">\n  <xsl:param name=\"jsx_is_first_panel_row\"/>\n  <xsl:param name=\"jsx_row_number\"/>\n  <xsl:param name=\"jsx_rowbg\"/>\n  <xsl:param name=\"jsx_cdfkey\"/>\n  <xsl:param name=\"jsx_descendant_index\"/>\n  <xsl:param name=\"jsx_selection_bg\"><xsl:choose>\n     <xsl:when test=\"@jsxselected=1\">background-image:url(<xsl:value-of select=\"$jsx_selection_bg_url\"/>);</xsl:when>\n   </xsl:choose></xsl:param>\n  <xsl:param name=\"jsx_cell_width\" select=\"##JSX_REPLACE##\"/>\n  <xsl:param name=\"jsx_true_width\">\n    <xsl:choose><xsl:when test=\"$jsx_use_categories!=''0'' and not(@jsxcategory=''0'') and (@jsxcategory or record)\">##JSX_REPLACE_ALL##</xsl:when><xsl:otherwise><xsl:value-of select=\"$jsx_cell_width\"/></xsl:otherwise></xsl:choose>\n  </xsl:param>\n  <xsl:param name=\"jsx_first_row_width_style\">\n    <xsl:choose><xsl:when test=\"$jsx_is_first_panel_row\">width:<xsl:value-of select=\"$jsx_true_width\"/>px;</xsl:when></xsl:choose>\n  </xsl:param>\n  <xsl:param name=\"jsx_colspan\">\n    <xsl:choose><xsl:when test=\"$jsx_use_categories!=''0'' and not(@jsxcategory=''0'') and (@jsxcategory or record)\"><xsl:value-of select=\"$jsx_column_count\"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose>\n  </xsl:param>\n  {1}\n</xsl:template>");m.yP=new
jsx3.util.MessageFormat('<xsl:call-template name="{0}">\n  <xsl:with-param name="jsx_cell_width" select="$jsx_true_width"/>\n  <xsl:with-param name="jsx_row_number" select="$jsx_row_number"/>\n  <xsl:with-param name="jsx_descendant_index" select="$jsx_descendant_index"/>\n</xsl:call-template>');m.DEFAULT_INFO_LABEL="Viewing rows {0} to {1} of {2}";m.ON_PAINT_PAGE="jsxpaintpage";m.PAGING_OFF=0;m.PAGING_2PASS=1;m.PAGING_CHUNKED=2;m.PAGING_PAGED=3;m.PAGING_STEPPED=4;m.SELECTION_UNSELECTABLE=0;m.SELECTION_ROW=1;m.SELECTION_MULTI_ROW=2;m.DEFAULT_ROW_HEIGHT=20;m.DEFAULT_PANEL_POOL_COUNT=5;m.DEFAULT_ROWS_PER_PANEL=50;m.DEFAULT_REAPER_INTERVAL=250;m.DEFAULT_PANEL_QUEUE_SIZE=3;m.DEFAULTXSLURL=jsx3.resolveURI("jsx:///xsl/jsxmatrix.xsl");m.DEFAULT_XSL_URL=m.DEFAULTXSLURL;m.SCROLL_INC=12;q._jsxiV=[];q.init=function(a){this.jsxsuper(a);};q.Vd=function(k,h,g){var
sb=this.vi(true,k);delete this._jsxSW;var
Fb=yc.getScrollSize()+1;var
ab=this.getScaleWidth()==1?k.parentwidth-Fb:this.b6();var
mc=this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT);sb.recalculate(k,h,g);var
Vb=sb.tp(0);Vb.recalculate({parentwidth:this._w(),parentheight:mc},h?h.childNodes[0]:null,g);var
Bb=Vb.tp(0).tp(0);Bb.recalculate({parentwidth:ab,parentheight:mc},h&&h.childNodes[0]?jsx3.html.selectSingleElm(h,0,0,0):null,g);var
Nb=sb.Zh()-mc;var
cc=sb.tp(1);cc.recalculate({parentwidth:this._w(),parentheight:Nb},h?h.childNodes[1]:null,g);var
Hc=cc.Jo()+cc.Zh();Nb=sb.Zh()-this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT);var
Db={};Db.left=cc.Ll()-1;Db.top=0;Db.height=Hc+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)-(Fb-yc.getScrollSizeOffset("scroll"));var
Jc=sb.tp(2);Jc.recalculate(Db,h?h.childNodes[2]:null,g);var
B={};B.top=Hc+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)-Fb;B.width=cc.Si();var
dc=sb.tp(3);dc.recalculate(B,h?h.childNodes[3]:null,g);var
zb=dc.tp(0);var
Rb=this.getScaleWidth()||ab-Fb<=sb.Si()?0:ab;zb.recalculate({width:Rb},h&&h.childNodes[3]?h.childNodes[3].childNodes[0]:null,g);if(h&&h.childNodes[3])if(this.getSuppressHScroller(0)==1||this.getScaleWidth()==1||zb.Si()<=dc.Si()){h.childNodes[3].style.display="none";this.setScrollLeft(0);}else h.childNodes[3].style.display="block";var
ic={};ic.left=Db.left;ic.top=Hc+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)-Fb;ic.height=sb.Zh()-ic.top;var
hc=sb.tp(4);hc.recalculate(ic,h&&h.childNodes[4]?h.childNodes[4]:null,g);var
E=this.Xj();var
Ic=this.oD(cc.Si());var
M=false;for(var
Cc=0;Cc<E.length;Cc++){var
xb=E[Cc].Vd({parentwidth:Ic[Cc],parentheight:mc},h?E[Cc].getRendered():null,g);M=M||xb==null||xb.w;}if(!M){}else if(h&&h.childNodes[0]){var
ac=[];for(var
Cc=0;Cc<E.length;Cc++)ac.push(E[Cc].vi(true).Oj());this.Ot(h.childNodes[0].childNodes[0],ac);Ic=[];for(var
Cc=0;Cc<E.length;Cc++)Ic.push(E[Cc].vi(true).Ll());this.D1(h.childNodes[0].childNodes[0],Ic);ac=[];for(var
Cc=0;Cc<E.length;Cc++)ac.push(E[Cc].vi(true).tp(1).Oj());if(this.getRenderingModel()=="hierarchical"){var
jb=this.EI({contextnodes:h.childNodes[1].childNodes[0].childNodes});this.vH(jb,ac);}else this.Ot(h.childNodes[1].childNodes[0],ac);this.QR();}else{Qb.trace("Race condition with view...");var
Fc=this;jsx3.sleep(function(){if(this.getParent())this.Ch(this.getParent().Ln(this),true);},null,this);}};q.D1=function(d,j){var
Ib=0;for(var
_=1;_<d.childNodes.length;_++){var
Wb=d.childNodes[_];Ib=Ib+j[_-1];Wb.style.left=Ib-4+"px";}};q.Ot=function(g,s){var
H=this.b6();for(var
X=0;X<g.childNodes.length;X++){var
z=g.childNodes[X];if(z.tagName.toLowerCase()=="table"){z.style.width=H+"px";var
B=this.mJ(z);if(B)for(var
hb=0;hb<B.childNodes.length;hb++)B.childNodes[hb].style.width=s[hb]+"px";}}};q.vH=function(f,g){var
Ic=this.b6();var
gb=Ic-this.oD()[0]+g[0];for(var
D=0;D<f.length;D++){var
sc=f[D];if(!(sc&&sc.childNodes))continue;var
z=sc.parentNode;if(z.tagName.toLowerCase()!="table")z=z.parentNode;var
pc=Ic-parseInt(z.style.width);z.style.width=Ic+"px";for(var
U=0;U<sc.childNodes.length;U++){var
Db=U==0&&sc.childNodes[0].getAttribute("jsxcolspan")>1?gb:g[U];sc.childNodes[U].style.width=Db+"px";if(U==0&&this.getRenderNavigators(1)!=0){z=sc.childNodes[U].childNodes[0].childNodes[0];var
vb=Db-parseInt(z.style.left)-1;z.style.width=Math.max(0,vb)+"px";var
nc=this.mJ(z);}}}};q.b6=function(i){if(!i)i=this.oD();return eval(i.join("0+")+"0")/10;};q.oD=function(g){if(typeof this._jsxSW=="object"){return this._jsxSW.truewidths;}else{if(!g){g=this._w();var
Ab={width:1000,height:10};var
vb=this.getBodyBorder();if(vb!=null&&vb!="")Ab.border=vb;g=g-(Ab.width-(new
yc(Ab)).Si());}var
F=[];var
N=0;var
cb;var
_=0;var
Ib=this.Xj();var
S={percent:[],wildcard:[],pixel:[]};for(var
u=0;u<Ib.length;u++){var
wb=Ib[u].getWidth();if(jsx3.util.strTrim(String(wb)).search(/\d*%/)==0){S.percent.unshift(u);cb=parseInt(parseInt(wb)/100*g);}else if(!isNaN(wb)){S.pixel.unshift(u);cb=Number(wb);}else{S.wildcard.unshift(u);if(this.getScaleWidth()){_++;cb="*";}else cb=m.Column.DEFAULT_WIDTH;}if(!isNaN(cb))N=N+cb;F.push(cb);}Qb.trace("Matrix Width Recalc, Pass 1 ("+this.getName()+"): "+F);if(this.getScaleWidth()){var
C=g-N;var
lb;if(_&&C>=0&&parseInt(C/_)>8){var
Cc=_;var
Kc=C/_;if(Kc>parseInt(Kc)){Kc=parseInt(Kc);lb=C-(_-1)*Kc;}else lb=Kc;for(var
u=0;u<F.length;u++)if(F[u]=="*"){F[u]=_==1?lb:Kc;_--;}_=Cc;}else if(_)for(var
u=0;u<F.length;u++)if(F[u]=="*")F[u]=8;Qb.trace("Matrix Width Recalc, Pass 2a ("+this.getName()+"): "+F);var
Vb=this.b6(F);var
zc=Vb-g;if(zc>0){var
Rb=zc;if(S.wildcard.length)Rb=this.Xv(F,S.wildcard,zc);if(S.percent.length&&Rb>0)Rb=this.Xv(F,S.percent,Rb);if(S.pixel.length&&Rb>0)Rb=this.Xv(F,S.pixel,Rb);}Qb.trace("Matrix Width Recalc, Pass 2b ("+this.getName()+"): "+F);}for(var
u=0;u<F.length;u++)if(F[u]<8)F[u]=8;Qb.trace("Matrix Width Recalc, Pass 3 ("+this.getName()+"): "+F);var
Vb=this.b6(F);var
C=g-Vb;if(C>0)F[F.length-1]+=C;Qb.trace("Matrix Width Recalc, Pass 4 ("+this.getName()+"): "+F);this._jsxSW={truewidths:F};return F;}};q.Xv=function(d,h,n){var
yb=0;var
Cb=parseInt(n/h.length);for(var
Rb=0;Rb<h.length;Rb++){var
Q=h[Rb];if(Rb==h.length-1)Cb=n-(h.length-1)*Cb;if(d[Q]-Cb<8){yb=yb+(8-(d[Q]-Cb));d[Q]=8;}else d[Q]-=Cb;}return yb;};q._w=function(){var
E=this.getParent().Ln(this).parentwidth;return this.getSuppressVScroller(0)==1?E:E-yc.getScrollSize();};q.Ln=function(d){var
Rb=d.getDisplayIndex();return {parentwidth:Rb!=null?this.oD()[Rb]:null,parentheight:this.vi(true).tp(0).Zh()};};q.zj=function(k){this.applyDynamicProperties();if(this.getParent()&&(k==null||isNaN(k.parentwidth)||isNaN(k.parentheight))){k=this.getParent().Ln(this);this.nk();}else if(k==null)k={};var
C=yc.getScrollSize()+1;k.left=0;k.top=0;k.width="100%";k.height="100%";k.boxtype="box";k.tagname="div";var
Y=new
yc(k);var
cb=this.getScaleWidth()==1?this._w():this.b6();var
I={};I.left=0;I.top=0;I.height=this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT);I.width="100%";I.parentwidth=this._w();I.boxtype="box";I.tagname="div";var
oc;if((oc=this.getHeaderBorder())!=null&&oc!="")I.border=oc;var
F=new
yc(I);Y.Od(F);var
Hc={};Hc.tagname="div";Hc.boxtype="box";Hc.top=0;Hc.left=0;var
jc=new
yc(Hc);F.Od(jc);var
Gc={};Gc.left=0;Gc.top=0;Gc.width="100%";Gc.parentwidth=F.Si();Gc.boxtype="box";Gc.tagname="table";var
Pb=new
yc(Gc);jc.Od(Pb);var
tb={};tb.boxtype="inline";tb.tagname="tr";var
N=new
yc(tb);Pb.Od(N);var
Cc=Y.Zh()-this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT);var
zc={};zc.left=0;zc.top=this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT);zc.parentwidth=this._w();zc.width="100%";zc.parentheight=Cc;zc.height="100%";zc.boxtype="box";zc.tagname="div";if((oc=this.getBodyBorder())!=null&&oc!="")zc.border=oc;var
G=new
yc(zc);Y.Od(G);if(this.getHeaderHeight()!=0&&F.getBorderWidth()!=G.getBorderWidth())Qb.warn("If the header border and body border do not share the same pixel width, the columns in the matrix may not align as expected ("+this.getName()+")\nHeader Border ("+this.getHeaderBorder()+") != Body Border ("+this.getBodyBorder()+")");var
qc={};qc.tagname="div";qc.boxtype="box";qc.top=0;qc.left=0;var
hc=new
yc(qc);G.Od(hc);var
H=G.Jo()+G.Zh();var
B={};B.boxtype="box";B.tagname="div";B.left=G.Ll()-1;B.top=0;B.width=C;B.height=H+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)-(C-yc.getScrollSizeOffset("scroll"));var
hb=new
yc(B);Y.Od(hb);var
S={};S.boxtype="inline";S.tagname="img";S.empty=true;S.left=0;S.top=0;S.width=1;S.height=this.getPagingModel()!=3?0:this.Xu()+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)+C;var
rb=new
yc(S);hb.Od(rb);var
Vb={};Vb.boxtype="box";Vb.tagname="div";Vb.left=G.Pk();Vb.top=H+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)-C;Vb.height=C;Vb.width=G.Si();var
nc=new
yc(Vb);Y.Od(nc);var
u={};u.boxtype="inline";u.tagname="img";u.empty=true;u.left=0;u.top=0;u.width=cb-C<=Y.Si()?0:cb;u.height=1;var
Nb=new
yc(u);nc.Od(Nb);var
Ab={};Ab.boxtype="box";Ab.tagname="div";Ab.left=B.left;Ab.top=H+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)-C;Ab.width=C;Ab.height=Y.Zh()-Ab.top;var
vb=new
yc(Ab);Y.Od(vb);return Y;};m.Tk={};m.Tk["mouseover"]=true;m.Tk["mouseout"]=true;m.Tk["dblclick"]=true;m.Tk["keydown"]=true;m.Tk["mousedown"]=true;m.Tk["click"]=true;m.Tk["mouseup"]=true;q.paint=function(){this.applyDynamicProperties();var
tc=this.getId();var
ac=this.vi(true);ac.setAttributes('id="'+tc+'" class="jsx30matrix" '+this.cn("mouseup","_onMouseUp"));var
cc=this.qk(m.Tk,1);var
Jc=ac.tp(1);Jc.setAttributes('id="'+tc+'_body" class="jsx30matrix_body" '+cc);var
cb=Jc.tp(0);cb.setStyles(this.Dg()+this.mg());cb.setAttributes(this.cn("mousewheel","ti",2));var
pc=ac.tp(2);pc.setAttributes(this.cn("scroll","EL")+this.cn("mouseover","OX")+this.cn("mouseout","UP")+this.cn("mousemove","Ow")+this.cn("mousedown","vF")+' unselectable="on" class="jsx30matrix_scrollv"');var
Bc=this.getSuppressVScroller(0)==1?"display:none;":"";pc.setStyles("z-index:10;overflow:scroll;"+Bc);var
wb=pc.tp(0);wb.setAttributes('src="'+Yb.SPACE+'"');var
Gc=ac.tp(3);Gc.setAttributes(this.cn("scroll","g6")+this.cn("mousedown","ZQ")+' unselectable="on" class="jsx30matrix_scrollh"');Bc=this.getSuppressHScroller(0)==1||this.getScaleWidth()==1||Gc.tp(0).Si()<=Gc.Si()?"display:none;":"";Gc.setStyles("z-index:10;overflow:auto;"+Bc);var
B=Gc.tp(0);B.setAttributes('src="'+Yb.SPACE+'"');var
Pb=ac.tp(4);Pb.setStyles("overflow:hidden;background-color:#e8e8f5;z-index:11;");var
vb="";var
Kc=this.getPagingModel(0);if(Kc==0||Kc==4){if(this.MR()==2)vb=vb+this.JW(-1);vb=vb+this.JW(0);if(this.MR()==1)vb=vb+this.JW(-1);}var
gb=this.Vw(true);var
hc=this.cn("mouseout","_ebMouseOutDropIcon");var
S=ac.paint().join(this.h4()+Jc.paint().join(cb.paint().join(vb+gb))+pc.paint().join(wb.paint().join(""))+Gc.paint().join(B.paint().join(""))+Pb.paint().join("&#160;")+'<div class="jsx30matrix_scroll_info"><span class="jsx30matrix_scroll_info">&#160;</span></div>'+'<div class="jsx30matrix_resize_bar">&#160;</div>'+'<div class="jsx30matrix_drop_icon" '+hc+">&#160;</div>");return S;};q.onAfterPaint=function(j){var
kc=this.getPagingModel(0);if(kc==0||kc==4){this.JV();}else jsx3.sleep(this.JV,"JV"+this.getId(),this);};q.Vw=function(s){var
Nc=this.getPagingModel(0);var
eb=Nc==0||Nc==4;if(s&&eb||!s&&!eb){var
pc=this.Xj();var
U=[];for(var
sc=0;sc<pc.length;sc++){var
Nb=pc[sc];var
Ub=Nb.getEditMasks();for(var
uc=0;uc<Ub.length;uc++){var
v=Ub[uc];if(this.ZK(v,Nb))if(v.emGetType()==m.EditMask.NORMAL||v.emGetType()==m.EditMask.DIALOG)U.push(v);}}return '<div id="'+this.getId()+'_masks" class="jsx30matrix_masks">'+this.paintChildren(U)+"</div>";}return "";};q.resetMask=function(){this.endEditSession();};q.repaintData=function(){var
jc=this.vE();if(jc){var
X=this.getScrollTop();var
hc="";var
Jc=this.getPagingModel(0);if(Jc==0||Jc==4){this.S2();if(this.MR()==2)hc=hc+this.JW(-1);hc=hc+this.JW(0);if(this.MR()==1)hc=hc+this.JW(-1);}var
pc=this.getDocument(jc);var
Kc=pc.getElementById(this.getId()+"_masks");if(Kc)Kc.parentNode.removeChild(Kc);jc.innerHTML=hc;this.JV(false,true);if(Kc)jc.appendChild(Kc);jsx3.sleep(function(){this.fX(X);},null,this);}};q.fX=function(s){var
zb=this.vE();if(s==null)s=this.getScrollTop();var
Ib=zb?zb.offsetHeight:0;if(Ib<s){this.setScrollTop(Ib);}else this.setScrollTop(s);this.QR(zb);};q.h4=function(){var
tc=this.getId();var
x=this.vi(true);var
u=this.vi(true).tp(0).Zh();var
Rb=x.tp(0);Rb.setAttributes('id="'+tc+'_head" class="jsx30matrix_head"');var
sb=Rb.tp(0);var
N=sb.tp(0);N.setAttributes('cellspacing="0" cellpadding="0" class="jsx30matrix_head_table"');var
ec=N.tp(0);var
Jb=[];var
kc=this.oD();var
qb=this.Xj();for(var
wc=0;wc<qb.length;wc++){qb[wc].ak({parentwidth:kc[wc],parentheight:u},null);Jb.push(qb[wc].paint());}var
Ib=Rb.paint().join(sb.paint().join(N.paint().join(ec.paint().join(Jb.join("")))+this.PW(qb)));return Ib;};q.repaintHead=function(){var
x=this.getDocument();var
qb=x.getElementById(this.getId()+"_head");if(qb){var
qc=this.h4();jsx3.html.setOuterHTML(qb,qc);}};q.Ph=function(j,c){var
z=this.getServer().getJSXById(c.id);var
ub=z.getDisplayIndex();this.SW(ub);if(j.leftButton()&&ub>=this.getFixedColumnIndex(0)&&this.getCanReorder()!=0){gc.publish(j);var
wb=c.cloneNode(true);var
wc='<table id="'+this.getId()+'_ghost" cellspacing="0" cellpadding="0" class="jsx30matrix_ghost" style="width:'+parseInt(c.offsetWidth)+'px;"><tr>'+jsx3.html.getOuterHTML(wb)+"</tr></table>";var
nc=this.getRendered(j).childNodes[0].childNodes[0];jsx3.html.insertAdjacentHTML(nc,"BeforeEnd",wc);var
sc=nc.lastChild;var
Q=this.oD();var
jc=0;for(var
C=0;C<this.LL();C++)jc=jc+Q[C];sc.style.left=jc+"px";this._jsxE_=jc;Lb.ll(j,sc,function(i,h){return [i,0];});gc.subscribe("mouseup",this,"gT");}else if(j.rightButton()){var
Zb=z.getMenu();if(Zb){var
ib=z.getServer().getJSX(Zb);if(ib!=null){var
B={objEVENT:j,objMENU:ib};var
kc=z.doEvent("jsxmenu",B);if(kc!==false){if(kc instanceof Object&&kc.objMENU instanceof jsx3.gui.Menu)ib=kc.objMENU;ib.showContextMenu(j,z);}}}}};q.gT=function(h){jsx3.EventHelp.reset();gc.unsubscribe("mouseup",this,"gT");var
_b=this.getRendered(h.event).childNodes[0].childNodes[0].lastChild;var
Mc=parseInt(_b.style.left);_b.parentNode.removeChild(_b);var
tb=this.getChildren();var
tc=this.Xj();var
Nb=tc[this.LL()];var
ib=jsx3.util.arrIndexOf(tb,Nb);if(Mc==this._jsxE_){if(this.getCanSort()!=0)this.Bg(h);}else if(this.getCanReorder()!=0){var
Cb=this.oD();var
pb=0;for(var
B=0;B<tc.length;B++){if(pb>=Mc){var
Xb=tc[B];var
W=jsx3.util.arrIndexOf(tb,Xb);this.WI(h,Nb,Xb);return;}pb=pb+Cb[B];}this.WI(h,Nb,tc[tc.length-1]);}};q.qu=function(l){return l.getSortPath();};q._T=function(h){return h.getSortDataType();};q.Bg=function(o){var
bc=this.Xj();var
Y=bc[this.LL()];if(Y&&Y.getCanSort()!=0&&this.getCanSort()!=0){this.FX();var
hc=jsx3.util.arrIndexOf(this.getChildren(),Y);var
Ac=this.qu(Y);var
Z=this._T(Y);var
P=this.doEvent("jsxbeforesort",{objEVENT:o,objCOLUMN:Y,strSORTPATH:Ac,strSORTTYPE:Z});if(P!==false){if(P!=null&&typeof P=="object")if(P.objCOLUMN!=null){Y=P.objCOLUMN;Ac=this.qu(Y);Z=this._T(Y);}this.setSortPath(Ac);this.setSortType(Z);this.doSort();this.doEvent("jsxaftersort",{objEVENT:o,objCOLUMN:Y,strSORTPATH:Ac,strSORTTYPE:Z});}}};q.doSort=function(e){if(e){this.setSortDirection(e);}else this.setSortDirection(this.getSortDirection()=="ascending"?"descending":"ascending");var
cb=this.getSortPath();var
Pb=this.Xj();for(var
Hc=0;Hc<Pb.length;Hc++)Pb[Hc]._applySortIcon(Pb[Hc].getSortPath()==cb);delete this._jsxAD;this.repaintData();};q.getSortPath=function(){return this.jsxsortpath==null?"":this.jsxsortpath;};q.setSortPath=function(b){this.jsxsortpath=b;};q.getSortType=function(){return this.jsxsorttype==null?"text":this.jsxsorttype;};q.setSortType=function(s){this.jsxsorttype=s;};q.getSortDirection=function(){return this.jsxsortdirection==null?"ascending":this.jsxsortdirection;};q.setSortDirection=function(p){this.jsxsortdirection=p;};q.getCanSort=function(){return this.jsxsort;};q.setCanSort=function(l){this.jsxsort=l;};q.WI=function(l,n,b){var
zb=this.Xj();var
xb=jsx3.util.arrIndexOf(zb,n);var
Vb=jsx3.util.arrIndexOf(zb,b);var
mb=this.getFixedColumnIndex(0);if(xb<=mb)return;if(Vb<mb)b=this.Xj()[mb];if(!b)return;var
C=this.insertBefore(n,b,true);if(C){var
w=n.getChildIndex();this.doEvent("jsxafterreorder",{objEVENT:l,intOLDINDEX:xb,intNEWINDEX:w});}};q.adoptChild=function(j,o,r){this.jsxsuper(j,false,r);this.nk();if(o!==false)this.repaint();};q.insertBefore=function(d,l,r){var
Cb=this.jsxsuper(d,l,false);if(Cb){this.nk();if(r!=false)this.repaint();}return Cb;};q.getCanReorder=function(){return this.jsxreorder;};q.setCanReorder=function(o){this.jsxreorder=o;};q.focusRowById=function(l){this.focusCellByIndex(l,0);};q.focusCellById=function(p,g){if(this.getRenderingModel()=="hierarchical")this.revealRecord(p);var
xb=this.av(p,g);if(xb){xb.focus();}else if(this.DK(p))jsx3.sleep(function(){jsx3.sleep(function(){this.focusCellById(p,g);},"focusdelay",this);},"focusdelay",this);};q.focusCellByIndex=function(p,o){if(this.getRenderingModel()=="hierarchical")this.revealRecord(p);var
S=this.jP(p,o);if(S){S.focus();}else if(this.DK(p))jsx3.sleep(function(){jsx3.sleep(function(){this.focusCellByIndex(p,o);},"focusdelay",this);},"focusdelay",this);};q.DK=function(j){if(this.getPagingModel()==3){var
db=this.getSortedIds();var
x=db.length;for(var
I=0;I<x;I++)if(db[I]==j){this.setScrollTop(this.getRowHeight(m.DEFAULT_ROW_HEIGHT)*I);this._jsxAD=this.getRowHeight(m.DEFAULT_ROW_HEIGHT)*I;this.N_().unshift({index:this.bD()});this.MT();return true;}}return false;};q.CH=function(e,s){this.HI(e,s);this._scrollIntoView(s);};q.tI=function(p,i){};q.getFocusStyle=function(k){return this.jsxfocusstyle?this.jsxfocusstyle:k?k:null;};q.setFocusStyle=function(j){delete this._jsxv_;this.jsxfocusstyle=j;};q.eq=function(j,i){if(typeof this._jsxv_!="object")this._jsxv_=this.jr(this.getFocusStyle(m.FOCUS_STYLE));this.Qs(j,this._jsxv_,i);};q.jr=function(g){var
B=/(-\S)/gi;var
Mc={};var
Db=g.split(";");for(var
Fc=0;Fc<Db.length;Fc++){var
G=Db[Fc]+"";var
ic=G.split(":");if(ic&&ic.length==2){var
ub=ic[0].replace(B,function(p,o){return o.substring(1).toUpperCase();});Mc[ub]=ic[1];}}return Mc;};q.Qs=function(o,h,d){if(d){for(var V in h)o.style[V]=h[V];}else for(var V in h)o.style[V]="";};q.wW=function(){return this._jsxcV;};q.WF=function(g){if(this._jsxcV!=g){var
v=this.hM();if(v)this.eq(v,false);}this._jsxcV=g;};q.resetFocusContext=function(g){this.WF();};q.hM=function(){return this.getDocument().getElementById(this.wW());};q.HI=function(f,g){this.K8(f);var
u=true;var
G=this.Xj();var
Fb=G[g.cellIndex];var
E=Fb.getEditMasks();for(var
tc=0;tc<E.length;tc++){var
Y=E[tc];if(this.ZK(Y,Fb))if(Y.emGetType()!=m.EditMask.NORMAL){u=false;break;}}if(u)g.focus();this.WF(g.id);this.eq(g,true);this.Iy(f,g);};q.gg=function(e,h){this.Wf(e);};q.Wf=function(n,s){if(s==null)s=this.getSelectedIds();for(var
hc=0;hc<s.length;hc++){var
L=s[hc];var
rc=this.getRecordNode(L);if(rc.getAttribute("jsxunselectable")=="1")continue;this.eval(rc.getAttribute("jsxexecute"),{strRECORDID:L});}if(s.length)this.doEvent("jsxexecute",{objEVENT:n,strRECORDID:s[0],strRECORDIDS:s});};q.executeRecord=function(c){var
qb=this.getRecordNode(c);if(qb)this.eval(qb.getAttribute("jsxexecute"),{strRECORDID:c});};q.Iy=function(l,a){var
Dc=this.getSelectionModel(1);var
Mc=this.XB(a);var
W=Mc.cell;var
Fb=W?W.cellIndex:null;var
bb=Mc.row;var
cb=bb.getAttribute("jsxid");var
L=this.MR()&&this.gK(bb);if(!L)if(this.I4().ctrl){this._L(cb);if(this.isRecordSelected(cb)){this.RJ(l,cb,null);}else this.W2(l,cb,bb,true,Fb);}else if(this.I4().shift){var
Hc=this.uE();if(Hc){var
_b=this.iN(Hc);if(_b)this.HL(l,_b,bb,Fb);}else{this._L(cb);this.W2(l,cb,null,false,Fb);}}else{this._L(cb);if(!this.isRecordSelected(cb))this.W2(l,cb,null,false,Fb);}this.l9(l,W,this.Xj()[Fb],L);delete this._jsxDz;};q.uL=function(){if(!this._jsxUZ)this._jsxUZ={bg:this.getServer().resolveURI(this.getSelectionBG(m.SELECTION_BG))};return this._jsxUZ.bg;};q.getSelectionBG=function(g){return this.jsxselectionbg?this.jsxselectionbg:g?g:null;};q.setSelectionBG=function(i){delete this._jsxUZ;this.jsxselectionbg=i;};q._L=function(g){this._jsxv3=g;};q.uE=function(){return this._jsxv3;};q.dH=function(){return this.getDocument().getElementById(this.uE());};q.wR=function(r,p,c){c.push(r);var
M=r.getParent();return !M.equals(p)?this.wR(M,p,c):c;};q.getSelectedNodes=function(){return this.getXML().selectNodes("//record[@"+"jsxselected"+"='1']");};q.getSelectedIds=function(){var
Jb=[];var
uc=this.getXML().selectNodeIterator("//record[@"+"jsxselected"+"='1']");while(uc.hasNext()){var
Nc=uc.next();Jb[Jb.length]=Nc.getAttribute("jsxid");}return Jb;};q.Ih=function(b){var
kc=this.getRecord(b);return kc&&(kc["jsxunselectable"]==null||kc["jsxunselectable"]!="1");};q.isRecordSelected=function(i){var
L=this.getRecord(i);return L!=null&&L["jsxselected"]=="1";};q.selectRecord=function(a){if(this.getSelectionModel()==0)return;if(!this.Ih(a))return;this.W2(false,a,null,this.getSelectionModel()==2);};q.deselectRecord=function(n){this.RJ(false,n,null);};q.deselectAllRecords=function(){var
Z=this.getSelectedIds();var
V=Z.length;for(var
Mb=0;Mb<V;Mb++)this.RJ(false,Z[Mb]);};q.W2=function(i,g,r,j,a){var
R=this.getSelectionModel(1);var
Hb=this.getRecordNode(g);var
Ub=j||i&&this.getCanDrag()==1;if(R==0||!Hb||Hb.getAttribute("jsxselected")=="1"&&Ub||Hb.getAttribute("jsxunselectable")=="1")return false;var
ic=j&&R==2;if(!ic)this.deselectAllRecords();Hb.setAttribute("jsxselected","1");r=r||this.iN(g);if(r!=null){var
qb="url("+this.uL()+")";for(var
O=0;O<r.childNodes.length;O++)r.childNodes[O].style.backgroundImage=qb;}this.lA(i,g,a);return true;};q.RJ=function(l,n,b){var
K=this.getRecordNode(n);if(!K||K.getAttribute("jsxselected")!="1")return false;K.removeAttribute("jsxselected");b=b||this.iN(n);if(b!=null&&b.childNodes){b.style.backgroundImage="";for(var
bc=0;bc<b.childNodes.length;bc++)b.childNodes[bc].style.backgroundImage="";}this.lA(l);return true;};q.zz=function(o){if(o.rowIndex!=null&&!isNaN(o.rowIndex)&&o.rowIndex>-1)return o.rowIndex;var
Hb=o.parentNode;if(Hb){var
v=Hb.childNodes.length;for(var
Zb=0;Zb<v;Zb++)if(Hb.childNodes[Zb]==o)return Zb;}return -1;};q.HL=function(r,i,o,s){if(!i||!o)return;var
uc=i.getAttribute("jsxid");var
Mb=o.getAttribute("jsxid");if(!this.Ih(uc)||!this.Ih(Mb))return;var
Ec=this.zz(i);var
Fb=this.zz(o);var
Ob=Math.min(Ec,Fb);var
B=Math.max(Ec,Fb);var
Eb=this.getSelectedIds();var
Jc=Eb.length;var
Cc={};if(this.getRenderingModel()!="hierarchical"){var
Ic=false;var
I=this.getPagingModel(0);if(I==2){var
nc=i.parentNode;var
Mc=o.parentNode;var
W=false;if(nc.tagName.toLowerCase()!="table"){W=true;nc=nc.parentNode;Mc=Mc.parentNode;}if(nc!=Mc){for(var
G=0;G<Jc;G++)this.RJ(false,Eb[G],this.iN(Eb[G]));var
T=nc.parentNode;var
db={};for(var
G=0;G<T.childNodes.length;G++)if(nc==T.childNodes[G])db.anchor=G;else if(Mc==T.childNodes[G])db.target=G;if(db.anchor<db.target){var
xc=db.anchor;var
Jb=db.target;Ob=Ec;B=Fb;}else{var
xc=db.target;var
Jb=db.anchor;Ob=Fb;B=Ec;}var
R=this.getRowsPerPanel(m.DEFAULT_ROWS_PER_PANEL);for(var
J=xc;J<=Jb;J++){var
tb=T.childNodes[J];var
Pb=J==xc?Ob:0;var
X=J==Jb?B:R-1;var
E=W?tb.childNodes[0]:tb;for(var
G=Pb;G<=X;G++){var
Rb=E.childNodes[G].getAttribute("jsxid");this.W2(false,Rb,E.childNodes[G],true,s);}}}else Ic=true;}if(Ic||I==0||I==1){for(var
G=0;G<Jc;G++){var
Kc=this.iN(Eb[G]);if(Ic||this.zz(Kc)<Ob||this.zz(Kc)>B){this.RJ(false,Eb[G],Kc);}else Cc[Eb[G]]=1;}var
E=i.parentNode;for(var
G=Ob;G<=B;G++){var
Rb=E.childNodes[G].getAttribute("jsxid");if(!Cc[Rb])this.W2(false,Rb,E.childNodes[G],true,s);}}}else{for(var
G=0;G<Jc;G++)this.RJ(false,Eb[G],this.iN(Eb[G]));var
lb=this.getRecordNode(this.getRenderingContext("jsxroot"));var
xb=this.getRecordNode(uc);var
ac=this.getRecordNode(Mb);var
_b=jsx3.util.List.wrap(this.wR(xb,lb,[]));var
mc=jsx3.util.List.wrap(this.wR(ac,lb,[]));var
jb=_b.filter(function(l){for(var
G=0;G<mc.size();G++)if(l.equals(mc.get(G)))return true;return false;});var
cc=jb.get(0);var
Bb=cc?this.iN(cc.getAttribute("jsxid")):this.mJ(this.nJ());var
N=[];var
gb=0;while(Bb&&gb<2){if(Bb==i)gb++;if(Bb==o)gb++;if(gb)N.push(Bb);Bb=gb<2?this.MA("S",Bb):null;}for(var
G=0;G<N.length;G++){var
Rb=N[G].getAttribute("jsxid");this.W2(false,Rb,N[G],true,s);}}this.lA(r,Mb,s);};q.lA=function(d,l,e){if(d&&d instanceof gc){this.doEvent("jsxselect",{objEVENT:d,strRECORDID:l,strRECORDIDS:this.getSelectedIds(),objCOLUMN:e!=null?this.Xj()[e]:null});this.doEvent("jsxchange",{objEVENT:d});}};q.l9=function(o,j,c,a){var
_=c.getEditMask();if(_!=null){var
Zb,lb;if(a){var
rb=this.a4();lb=rb[c.getPath()];Zb="jsxautorow";}else{Zb=j.parentNode.getAttribute("jsxid");lb=c.getValueForRecord(Zb);}var
zb=this.getRendered(j);var
N=this.vE();var
ec=_.emGetType()==m.EditMask.NORMAL||_.emGetType()==m.EditMask.DIALOG;if(ec){var
t=this.doEvent("jsxbeforeedit",{objEVENT:o,strRECORDID:Zb,objCOLUMN:c});if(t===false)return;if(t!=null&&typeof t=="object")if(typeof t.objMASK!="undefined")_=t.objMASK;}var
yb=jsx3.html.getRelativePosition(N,j);var
Ub=jsx3.html.getRelativePosition(zb,zb);Ub.W-=parseInt(N.style.left);Ub.H-=parseInt(N.style.top);var
U=this._jsxON;if(U&&U.mask&&U.mask.emGetSession())this.endEditSession();if(_.cC(lb,yb,Ub,this,c,Zb,j)){this._jsxON={mask:_,column:c,recordId:Zb,value:lb};gc.subscribeLoseFocus(this,this.getRendered(j).childNodes[1],"ZO");}}};q.getAutoRowSession=function(){return this.a4();};q.a4=function(){if(!this._jsxyQ){this._jsxyQ={jsxid:jsx3.xml.CDF.getKey()};this._jsxFx={jsxid:this._jsxyQ.jsxid};}return this._jsxyQ;};q.ZR=function(){if(this._jsxyQ)for(var Sb in this._jsxyQ)if(this._jsxFx[Sb]!=this._jsxyQ[Sb])return true;return false;};q.QX=function(f){var
zc=this.a4();zc[f.column.getPath()]=f.newvalue;};q.yC=function(e,n){if(n!==false)this.K8(e);var
Gc=this.a4();if(Gc!=null){delete this._jsxyQ;var
Q;if(e)Q=this.doEvent("jsxbeforeappend",{objEVENT:e,objRECORD:Gc});if(Q!==false){var
rc=this.insertRecord(Gc,null,true);if(e)this.doEvent("jsxafterappend",{objEVENT:e,objRECORDNODE:rc});}var
Ub={jsxid:"jsxautorow"};this.insertRecord(Ub,null,false);this.redrawRecord("jsxautorow",2);this.deleteRecord("jsxautorow",false);}};q.commitAutoRowSession=function(i,j){this.yC(i,false);if(!isNaN(j)){var
rc=this.iN("jsxautorow");if(rc&&rc.childNodes[+j])rc.childNodes[+j].focus();}};q.pt=function(){delete this._jsxyQ;};q.gK=function(l){if(!l)return false;if(l.getAttribute("jsxid")!="jsxautorow")return false;var
Vb=l.parentNode;if(Vb.tagName.toLowerCase()!="table")Vb=Vb.parentNode;return Vb.getAttribute("jsxautorow")=="true";};q.K8=function(e,d){var
Q=this._jsxON;if(Q!=null){if(!d){delete this._jsxON;gc.unsubscribeLoseFocus(this);}var
z=d?Q.mask.emGetValue():Q.mask.Z0();var
t=Q.recordId=="jsxautorow"&&this.MR()&&this.gK(this.iN("jsxautorow"));var
I=true;if(e&&t){var
_=this.iN("jsxautorow");I=jsx3.html.findElementUp(e.srcElement(),function(h){return h==_;},true)==null;}if(!(I&&t&&this.ZR()))if(Q.value===z)return;var
Fc=Q.mask.emGetType()==m.EditMask.NORMAL||Q.mask.emGetType()==m.EditMask.DIALOG;var
Fb=true;if(Fc){if(e!=null)Fb=this.doEvent("jsxafteredit",{objEVENT:e,strRECORDID:Q.recordId,objCOLUMN:Q.column,strNEWVALUE:z});if(Fb!=null&&typeof Fb=="object")if(typeof Fb.strNEWVALUE!="undefined")z=Fb.strNEWVALUE;var
Zb=Q.column.getPath()=="jsxid";if(Zb&&this.getRecordNode(z))Fb=false;if(Fb!==false){if(d)Q.value=z;if(t){Q.newvalue=z;this.QX(Q);var
Ic=this.a4();var
N={};for(var Cc in Ic)N[Cc]=Ic[Cc];N.jsxid="jsxautorow";this.insertRecord(N,null,false);this.redrawCell("jsxautorow",Q.column);this.deleteRecord("jsxautorow",false);if(I&&!d&&this.ZR())this.yC(e,false);}else if(Zb){this.insertRecordProperty(Q.recordId,"jsxid",z,false);this.redrawCell(z,Q.column);}else{Q.column.setValueForRecord(Q.recordId,z);this.redrawCell(Q.recordId,Q.column);}}}if(e!=null&&Fb!==false)this.doEvent("jsxaftercommit",{objEVENT:e,strRECORDID:Q.recordId,objCOLUMN:Q.column,strVALUE:z});}};q.endEditSession=function(j){this.K8(j);};q.collapseEditSession=function(d,i){var
Hb=this._jsxON;if(Hb!=null){Hb.mask.emCollapseEdit(d);this.endEditSession(d);i.focus();}};q.ZO=function(o){var
ac=o.event.srcElement();var
bc=this._jsxON;if(bc&&!bc.f2&&!bc.mask.containsHtmlElement(ac))this.K8(o.event);};q.ZK=function(r,b){if(r._jsxkP)return true;if(r.instanceOf(jsx3.gui.Form)){m.EditMask.jsxclass.mixin(r,true);}else if(jsx3.gui.Dialog&&r instanceof jsx3.gui.Dialog){m.DialogMask.jsxclass.mixin(r,true);m.BlockMask.jsxclass.mixin(r,true);m.EditMask.jsxclass.mixin(r,true);}else if(r instanceof Yb){m.BlockMask.jsxclass.mixin(r,true);m.EditMask.jsxclass.mixin(r,true);}else return false;r.emInit(b);r._jsxkP=true;return true;};q.Th=function(j,o){j.cancelBubble();jsx3.gui.Event.publish(j);var
v=j.srcElement();var
L=this.XB(v);var
Y=v.getAttribute("jsxtype");if(Y=="plusminus"||Y=="paged"){this.O3(j,v);}else while(v&&v!=o){if(v.getAttribute("jsxtype")=="record")if(!jsx3.gui.isMouseEventModKey(j)&&!j.shiftKey()){var
xb=L.row.getAttribute("jsxid");var
D=this.getSelectedIds();var
Ic=D.length==1&&xb==D[0]?false:j;this.deselectAllRecords();this.W2(Ic,xb,L.row,false,L.cell?L.cell.cellIndex:null);return;}v=v.parentNode;}};q.O3=function(a,l,h){var
xb=this.DD(l);var
Lc=this.mJ(xb.previousSibling).getAttribute("jsxid");var
nc=this.getRecordNode(Lc);if(!nc.selectSingleNode("./record"))return;if(h==null)h=false;if(l.nodeType==3)l=l.parentNode;var
tb=l.getAttribute("jsxtype");if(xb.style.display=="none"||h){h=true;nc.setAttribute("jsxopen","1");xb.style.display="";if(this.getRenderNavigators(1)!=0)l.style.backgroundImage="url("+this.getUriResolver().resolveURI(this.getIconMinus(m.ICON_MINUS))+")";if(this.G0(xb)){Qb.trace("Fetch the content belonging to: "+Lc);var
ac={};ac.jsx_panel_css="position:relative;";ac.jsx_column_widths=this.b6();ac.jsx_rendering_context=Lc;ac.jsx_context_index=xb.getAttribute("jsxcontextindex");xb.innerHTML=this.doTransform(ac);if(this.getRenderNavigators(1)!=0)l.setAttribute("jsxtype","plusminus");var
Z={painted:1,token:m.getToken(),contextnodes:xb.childNodes};this.tY()[0]=Z;this.pX(Z);}}else{nc.removeAttribute("jsxopen");xb.style.display="none";if(this.getRenderNavigators(1)!=0)l.style.backgroundImage="url("+this.getUriResolver().resolveURI(this.getIconMinus(m.ICON_PLUS))+")";}this.QR();if(a)this.doEvent("jsxtoggle",{objEVENT:a,strRECORDID:Lc,objRECORD:nc,bOPEN:h});};q.toggleItem=function(l,b){var
ic=this.jP(l,0);if(ic!=null){while(ic&&ic.getAttribute&&ic.getAttribute("jsxtype")!="plusminus"&&ic.getAttribute("jsxtype")!="paged")ic=ic.childNodes[0];this.O3(false,ic,b);}};q.revealRecord=function(f){var
u=this.getRecordNode(f);if(u){if(this.getRenderingModel()=="hierarchical"){var
K=[];do
K.push(u.getAttribute("jsxid"));while((u=u.getParent())!=null&&u.getNodeName()=="record");for(var
Fb=K.length-1;Fb>=0;Fb--)this.toggleItem(K[Fb],true);}this.synchronizeVScroller();var
Jb=this.jP(f,0);if(Jb){this._scrollIntoView(Jb);}else if(this.DK(f))jsx3.sleep(function(){jsx3.sleep(function(){var
Jb=this.jP(f,0);if(Jb)this._scrollIntoView(Jb);},"pagedfocusdelay",this);},"pagedfocusdelay",this);}};q.DD=function(g){while(!g.tagName||g&&g.tagName&&g.tagName.toLowerCase()!="table"||g.id=="")g=g.parentNode;return g.nextSibling;};q.getDragIcon=function(n,s,l,c){var
Ob=jsx3.EventHelp.DRAGIDS;var
Lc="";var
hb=n.id;var
C=0.4;var
M=n.getAttribute("jsxid");if(s.Ih(M)&&jsx3.util.arrIndexOf(Ob,M)==-1)Ob.push(M);for(var
oc=0;oc<Ob.length&&oc<4;oc++){var
eb=s.iN(Ob[oc]);if(eb)Lc=Lc+s.YV(eb,C);C=C-0.1;}return Lc;};q.YV=function(b,k){var
C=b;while(C.tagName.toLowerCase()!="table")C=C.parentNode;var
Hc=C.cloneNode(false);var
eb=b.cloneNode(true);Hc.appendChild(eb);Hc.style.width="300px";eb.id="";Hc.id="";return "<div id='JSX' class='jsx30matrix_dragicon' style='"+jsx3.html.getCSSOpacity(k)+"'>"+jsx3.html.getOuterHTML(Hc)+"</div>";};q.Sf=function(l,a){this.ZZ(l);if(l.leftButton()){var
dc=l.srcElement();var
qb=this.XB(dc);if(qb==null)return;if(qb){a=qb.cell;if(this.wW()!=a.id){a.focus();}else{this.jB();this.HI(l,a);}if(this.getCanDrag()==1&&this.getSelectionModel(1)>0){var
tc=this.getSelectedIds();var
Tb=qb.row.getAttribute("jsxid");var
vc=jsx3.util.List.wrap(tc);if(vc.indexOf(Tb)==-1)tc=[Tb];if(this.Ih(Tb)&&jsx3.util.arrIndexOf(tc,Tb)==-1)tc.push(Tb);this.doDrag(l,qb.row,this.getDragIcon,{strDRAGIDS:tc});}}}gc.publish(l);l.cancelAll();};q.Wh=function(j,c){var
D=j.toElement();if(!D)return;var
qc=D.getAttribute("jsxtype");var
tc=this.XB(D);if(!tc)return;var
Nc=tc.row.getAttribute("jsxid");c=this.z7(tc.row);if(jsx3.EventHelp.isDragging()&&this.getCanDrop()==1&&jsx3.EventHelp.getDragIds()[0]!=null){if(qc=="plusminus"&&this.getRecordNode(Nc).getAttribute("jsxopen")!="1"||qc=="paged"){var
ec=this;j.bg();m.TOGGLETIMEOUT=window.setTimeout(function(){if(ec.getParent()!=null)ec.O3(j,D);},m.NF);}var
Q=this.doEvent("jsxbeforedrop",{objEVENT:j,strRECORDID:Nc,objSOURCE:jsx3.EventHelp.getDragSource(),strDRAGIDS:jsx3.EventHelp.getDragIds(),strDRAGTYPE:jsx3.EventHelp.getDragType(),objGUI:c});if(!(Q===false)){var
xb=this.getRendered(j);var
F=this.getAbsolutePosition(xb,tc.row);var
Hc=this.yS(xb);var
Jb=this.getRenderingModel()=="hierarchical"&&this.getRenderNavigators(1)!=0?parseInt(tc.row.childNodes[0].childNodes[0].childNodes[0].style.left):4;if(this.getRenderingModel()!="hierarchical"||F.H/3>j.getOffsetY()){Hc.style.top=F.T-4+"px";Hc.style.width=this._w()-Jb-8+"px";Hc.style.height="7px";Hc.style.backgroundImage="url("+m.INSERT_BEFORE_IMG+")";Hc.setAttribute("dropverb","insertbefore");}else{Jb=Jb+26;Hc.style.width="12px";Hc.style.height="12px";Hc.style.top=F.T-10+F.H+"px";Hc.style.backgroundImage="url("+m.APPEND_IMG+")";Hc.setAttribute("dropverb","append");}Hc.style.left=Jb+"px";Hc.setAttribute("rowcontext",Nc);Hc.style.display="block";}}else if(this.getEvent("jsxspy")){this.applySpyStyle(D);var
Vb=j.clientX()+jsx3.EventHelp.DEFAULTSPYLEFTOFFSET;var
Ic=j.clientY()+jsx3.EventHelp.DEFAULTSPYTOPOFFSET;j.bg();var
ec=this;var
G=this.Xj()[tc.cell.cellIndex];if(m.SPYTIMEOUT)window.clearTimeout(m.SPYTIMEOUT);m.SPYTIMEOUT=window.setTimeout(function(){m.SPYTIMEOUT=null;if(ec.getParent()!=null)ec.sM(j,Vb,Ic,Nc,G,D);},jsx3.EventHelp.SPYDELAY);}};q.sM=function(n,h,d,l,b,r){this.removeSpyStyle(r);var
Hc=this.doEvent("jsxspy",{objEVENT:n,objCOLUMN:b,strRECORDID:l});if(Hc){Lb.hideSpy();this.showSpy(Hc,h,d);}};q.OX=function(c,j){this.f8(j.parentNode);if(jsx3.EventHelp.isDragging()&&this.getCanDrop()==1&&jsx3.EventHelp.getDragIds()[0]!=null){var
Bc=this;this._jsxOq={offsety:c.getOffsetY(),offsetheight:j.offsetHeight,scrollheight:j.scrollHeight};this._jsxOq.interval=window.setInterval(function(){Bc.Fy();},m.AUTO_SCROLL_INTERVAL);}};q.Fy=function(){if(this._jsxOq.offsety<this._jsxOq.offsetheight/2){if(this.getScrollTop()>0)this.setScrollTop(this.getScrollTop()-20);}else if(this.getScrollTop()<this._jsxOq.scrollheight)this.setScrollTop(this.getScrollTop()+20);};q.UP=function(e,h){if(this._jsxOq){window.clearInterval(this._jsxOq.interval);delete this._jsxOq;}};q.Ow=function(h,e){if(jsx3.EventHelp.isDragging()&&this.getCanDrop()==1&&jsx3.EventHelp.getDragIds()[0]!=null&&this._jsxOq){this._jsxOq.offsety=h.getOffsetY();this._jsxOq.offsetheight=e.offsetHeight;this._jsxOq.scrollheight=e.scrollHeight;}};q._ebMouseOutDropIcon=function(k,b){if(!k.isFakeOut(b.parentNode.childNodes[1]))this.f8(b.parentNode);};q.gn=function(h,e){var
O=h.fromElement();if(h.isFakeOut(e))this.f8(e.parentNode);if(!jsx3.EventHelp.isDragging()&&this.getEvent("jsxspy")){var
Lc=h.toElement();var
Vb=false;try{Vb=!Lc||Lc.className!="jsx30spyglassbuffer";}catch(Kc){Vb=true;}if(Vb){jsx3.sleep(Lb.hideSpy);this.removeSpyStyle(O);if(m.SPYTIMEOUT)window.clearTimeout(m.SPYTIMEOUT);}}if(O==null||h.isFakeOut(e.parentNode)&&O.getAttribute("jsxtype")!="plusminus")return;var
V=O.getAttribute("jsxtype");var
lc=this.XB(O);if(!lc)return;var
sb=lc.row.getAttribute("jsxid");e=this.z7(lc.row);if(jsx3.EventHelp.isDragging()&&this.getCanDrop()==1){if(V=="plusminus")window.clearTimeout(m.TOGGLETIMEOUT);var
mc=this.doEvent("jsxcanceldrop",{objEVENT:h,strRECORDID:sb,objSOURCE:jsx3.EventHelp.getDragSource(),strDRAGIDS:jsx3.EventHelp.getDragIds(),strDRAGTYPE:jsx3.EventHelp.getDragType(),objGUI:e});this.f8(this.getRendered(h));}};q.XB=function(l){if(l.getAttribute("jsxtype")=="record")return {row:l,cell:null};while(l.parentNode.getAttribute("jsxtype")!="record"){l=l.parentNode;if(l.tagName.toLowerCase()=="body"||l.id==this.getId())return null;}return {row:l.parentNode,cell:l};};q.z7=function(o){if(this.getRenderingModel()=="hierachical"){o=this.DD(o).parentNode;}else if(this.getPagingModel(0)!=3)while(o.tagName.toLowerCase()!="table")o=o.parentNode;return o;};q.ZY=function(p,i){};q.ti=function(n,r){var
u=n.getWheelDelta();var
nc=this.vE();var
wb=this.getScrollTop();wb=Math.max(0,Math.min(wb-u*m.SCROLL_INC,nc.offsetHeight));this.setScrollTop(wb,r);};q._isDescendantOrSelf=function(h,g){while(h&&g){if(h.equals(g))return true;h=h.getParent();}return false;};q._onMouseUp=function(j,c){var
Mb=j.srcElement()&&j.srcElement().className=="jsx30matrix_drop_icon"?this.iN(j.srcElement().getAttribute("rowcontext")).childNodes[0]:j.srcElement();var
xc=this.XB(Mb);if(this.getCanDrop()==1&&jsx3.EventHelp.isDragging()){if(jsx3.EventHelp.getDragType()=="JSX_GENERIC"){jsx3.sleep(function(){this.f8();},null,this);var
sb=jsx3.EventHelp.getDragSource();if(sb&&sb.instanceOf(jsx3.xml.CDF)){var
zb=jsx3.gui.isMouseEventModKey(j);var
tb=sb.doEvent("jsxadopt",{objEVENT:j,strRECORDID:jsx3.EventHelp.getDragId(),strRECORDIDS:jsx3.EventHelp.getDragIds(),objTARGET:this,bCONTROL:zb});var
ac=this.yS(this.getRendered(j));var
M=ac.getAttribute("dropverb")=="insertbefore";var
kc=xc?xc.row.getAttribute("jsxid"):null;var
Cb={objEVENT:j,objSOURCE:sb,strDRAGIDS:jsx3.EventHelp.getDragIds(),strDRAGTYPE:jsx3.EventHelp.getDragType(),strDRAGID:jsx3.EventHelp.getDragId(),strRECORDID:kc,bINSERTBEFORE:M,objCOLUMN:xc!=null?this.Xj()[xc.cell.cellIndex]:null,bALLOWADOPT:tb!==false};var
L=this.doEvent(zb?"jsxctrldrop":"jsxdrop",Cb);if(tb!==false&&L!==false){var
ic=jsx3.EventHelp.getDragIds();for(var
Ib=0;Ib<ic.length;Ib++)if(!(this==sb&&xc&&this._isDescendantOrSelf(this.getRecordNode(xc.row.getAttribute("jsxid")),this.getRecordNode(ic[Ib])))){sb.deleteRecordProperty(ic[Ib],"jsxselected",false);var
Ac;if(M){Ac=true;var
Zb=this.adoptRecordBefore(sb,ic[Ib],kc);}else{Ac=xc!=null;var
Zb=this.adoptRecord(sb,ic[Ib],this.getRenderingModel()=="hierarchical"&&xc?xc.row.getAttribute("jsxid"):null,xc!=null);}}if(!Ac&&!xc)this.repaint();}}}jsx3.EventHelp.reset();}else if(j.rightButton()){var
bb=this.getMenu();if(bb){var
mc=this.getServer().getJSX(bb);if(mc!=null){var
_b,Ec;if(xc){_b=this.Xj()[xc.cell.cellIndex];Ec=xc.row.getAttribute("jsxid");}var
nb={objEVENT:j,objMENU:mc,strRECORDID:Ec,objCOLUMN:_b};var
ab=this.doEvent("jsxmenu",nb);if(ab!==false){if(ab instanceof Object&&ab.objMENU instanceof jsx3.gui.Menu)mc=ab.objMENU;mc.showContextMenu(j,this,Ec);}}}}};q.ZZ=function(k){this._jsxDz={ctrl:jsx3.gui.isMouseEventModKey(k),shift:k.shiftKey(),alt:k.altKey()};};q.I4=function(){return this._jsxDz!=null?this._jsxDz:{};};q.Rn=function(j,o){if(this.jsxsupermix(j,o))return;var
gb=j.keyCode();var
B=j.hasModifier(true);var
Nc=gb==9&&!B;var
w=this.getSelectionModel(1);this.ZZ(j);if(this.wW()==null){var
P=this.Vq();if(P){this.WF(P.id);}else return;}var
Cb=this.hM();var
J=this.MR()&&Cb&&this.gK(Cb.parentNode);var
Lc=false;if(J&&(gb==13||gb==40||gb==38||Cb.parentNode.lastChild==Cb&&(Nc&&!j.shiftKey()||gb==39)||Cb.parentNode.firstChild==Cb&&(Nc&&j.shiftKey()||gb==37))){var
cc=Cb.cellIndex;if(gb==13){this.K8(j);var
kb=Cb.parentNode;if(!kb)kb=this.iN("jsxautorow");if(kb&&kb.childNodes[cc])kb.childNodes[cc].focus();}else if(this.MR()==2&&gb==40){var
vc=this.nJ();if(vc){var
fb=this.mJ(vc);if(fb)fb.childNodes[cc].focus();}}else if(this.MR()==1&&gb==38){var
vc=this.CW();if(vc){var
fb=this.ZI(vc);if(fb)fb.childNodes[cc].focus();}}else if(Cb.parentNode.lastChild==Cb&&(Nc&&!j.shiftKey()||gb==39)){Cb.parentNode.firstChild.focus();}else if(Cb.parentNode.firstChild==Cb&&(Nc&&j.shiftKey()||gb==37))Cb.parentNode.lastChild.focus();Lc=true;}else if(Cb){var
cc=Cb.cellIndex;var
W=Cb.parentNode.getAttribute("jsxid");if(gb==38||gb==13&&j.shiftKey()){var
sc=this.P3("N",Cb,true,cc);Lc=this.RO(sc);}else if(gb==40||gb==13&&!j.shiftKey()&&w==0){var
sc=this.P3("S",Cb,true,cc);Lc=this.RO(sc);}else if(gb==37||Nc&&j.shiftKey()){if(this.getRenderingModel()=="hierarchical"&&cc==0&&this.getSuppressVScroller()!=1){var
Fc=Cb.parentNode.getAttribute("jsxid");var
bc=this.getRecordNode(Fc);var
rc=bc.getAttribute("jsxopen");if(rc==1&&bc.selectSingleNode("record")){var
Mb=this.P1(Cb);this.O3(j,Mb,false);Lc=true;}else{var
sc=this.P3("W",Cb,true,cc);Lc=this.RO(sc);}}if(!Lc){var
sc=this.P3("W",Cb,true,cc);Lc=this.RO(sc);}}else if(gb==39||Nc&&!j.shiftKey()){if(this.getRenderingModel()=="hierarchical"&&cc==0&&this.getSuppressVScroller()!=1){var
Fc=Cb.parentNode.getAttribute("jsxid");var
bc=this.getRecordNode(Fc);var
rc=bc.getAttribute("jsxopen");if(rc!=1&&(bc.getAttribute("jsxlazy")=="1"||bc.selectSingleNode("record"))){var
Mb=this.P1(Cb);this.O3(j,Mb,true);Lc=true;}else{var
sc=this.P3("E",Cb,true,cc);Lc=this.RO(sc);}}if(!Lc){var
sc=this.P3("E",Cb,true,cc);Lc=this.RO(sc);}}else if(gb==13){this.Wf(j);Lc=true;}else if(Nc&&j.shiftKey()){this.focus();Lc=true;}else if(Nc){this.getRendered(j).lastChild.focus();Lc=true;}}if(Lc)j.cancelAll();};q.RO=function(j){if(j){jsx3.sleep(function(){try{j.focus();}catch(Kc){}});return true;}};q.P1=function(i){var
Mc=i.childNodes[0].childNodes[0];var
Jb=this.mJ(Mc);if(Jb)return Jb.childNodes[0];};q.N2=function(){return this._jsxP_;};q.jB=function(l){this._jsxP_=l;};q.P3=function(l,o,e,f){var
K=this.getSelectionModel(1);if(l=="E"){this.jB();if(o.parentNode.lastChild!=o){return o.nextSibling;}else if(o.parentNode.lastChild==o&&K>0){return o.parentNode.firstChild;}else{l="S";o=o.parentNode.firstChild;f=0;}}else if(l=="W"){this.jB();if(o.parentNode.firstChild!=o){return o.previousSibling;}else if(o.parentNode.firstChild==o&&K>0){return o.parentNode.lastChild;}else{l="N";o=o.parentNode.lastChild;f=o.cellIndex;}}var
jb=this.AM(l,o.parentNode,e);if(jb){if(this.N2()&&(l=="N"||l=="S")&&jb.childNodes.length>1){f=this.N2();this.jB();}var
u=jb.childNodes[f];if(u){return u;}else{this.jB(f);return jb.childNodes[0];}}else return null;};q.AM=function(c,g,o){if(c=="W")c="N";else if(c=="E")c="S";if(this.getRenderingModel()=="hierarchical")return this.MA(c,g);if(c=="N"&&g.previousSibling&&g.previousSibling.tagName.toLowerCase()!="colgroup"){return g.previousSibling;}else if(c=="S"&&g.nextSibling){return g.nextSibling;}else{var
Mb=this.F8(this.GA(g));var
K;var
lb=this.getRenderingModel()=="hierarchical"?this._O():this.tY().length;if(c=="N"&&Mb==0||c=="S"&&Mb==lb-1){if(c=="N"&&this.MR()==2||c=="S"&&this.MR()==1)return this.mJ(this.IU());else return null;}else if(c=="N"&&(K=this.HB(Mb-1))!=null){var
Rb=this.getRenderingModel()=="hierarchical"?1:this.getRowsPerPanel(m.DEFAULT_ROWS_PER_PANEL);return this.ZI(K);}else if(c=="S"&&(K=this.HB(Mb+1))!=null)return this.mJ(K);}return null;};q.MA=function(j,s){var
fc=s;if(j=="N"){while(fc.tagName.toLowerCase()!="table")fc=fc.parentNode;var
V=this.zv(fc.parentNode.previousSibling);if(V)return V;var
Ec=fc.parentNode.parentNode.previousSibling;return this.mJ(Ec);}else if(j=="S"){while(fc.tagName.toLowerCase()!="table")fc=fc.parentNode;var
Q=fc.nextSibling;if(Q&&Q.style.display.toLowerCase()!="none"){var
kb=Q.childNodes[0].childNodes[0];return this.mJ(kb);}Q=fc.parentNode.nextSibling;if(Q){var
kb=Q.childNodes[0];return this.mJ(kb);}return this.K1(fc.parentNode);}return null;};q.zv=function(c){if(c){var
Zb=c.childNodes[1];if(Zb&&Zb.style.display.toLowerCase()!="none"&&Zb.childNodes.length){var
v=Zb.lastChild;Zb=v.childNodes[1];if(Zb&&Zb.style.display.toLowerCase()!="none"&&Zb.childNodes.length){return this.zv(v);}else return this.mJ(v.childNodes[0]);}return this.mJ(c.childNodes[0]);}return null;};q.K1=function(a){var
L=a.parentNode.parentNode.nextSibling;if(L){return this.mJ(L.childNodes[0]);}else{var
nc=a.parentNode.parentNode;if(nc)return this.K1(nc);}return null;};q._scrollIntoView=function(o){var
Vb=jsx3.html.getRelativePosition(this.vE(),o);var
_=this.getScrollTop();var
Jc=Vb.T;var
Ib=parseInt(this.vi(true).tp(1).Zh()-yc.getScrollSize()+1);if(!(Jc>_&&Jc+Vb.H<_+(Ib-(yc.getScrollSize()+1)))){var
J=Math.abs(Jc-_);var
Ab=Math.abs(Jc-(_+Ib));if(Ab<J){if(Ab==0)Ab=Vb.H;this.setScrollTop(_+Ab);}else this.setScrollTop(Jc-(yc.getScrollSize()+1));}if(this.getScaleWidth()!=1){var
sb=this.getScrollLeft();var
tc=Vb.L;var
yb=parseInt(this.vi(true).tp(1).Si()-yc.getScrollSize()+1);if(!(tc>sb&&tc+Vb.W<sb+(yb-(yc.getScrollSize()+1)))){var
Sb=Math.abs(tc-sb);var
Jb=Math.abs(tc-(sb+yb));if(Jb<Sb){this.setScrollLeft(tc);}else this.setScrollLeft(tc-(yc.getScrollSize()+1));}}};q.PW=function(d){var
t=[];var
Bb=0;var
mb=this.vi().tp(0);var
F=mb.Zh();var
Fc=this.oD();for(var
rb=0;rb<d.length;rb++){var
Ib=d[rb].vi();Bb=Bb+Ib.Ll();var
Jb=this.getResizable()!=0&&rb<d.length-1&&d[rb].getResizable()!=0;if(Jb){var
tb=this.cn("mousedown","U8",3)+this.cn("dblclick","_D",3);var
H="";}else{var
tb="";var
H="visibility:hidden;";}t.push('<div class="jsx30matrix_resize_anchor" jsxindex="'+rb+'" style="left:'+(Bb-4)+"px;"+H+"width:"+4+"px;background-image:url("+Yb.SPACE+");height:"+F+'px;" '+tb+">&#160;</div>");}return t.join("");};q.U8=function(r,s){if(!r.leftButton())return;gc.publish(r);this.endEditSession();var
Hc=jsx3.util.arrIndexOf(this.getChildren(),this.Xj()[Number(s.getAttribute("jsxindex"))]);this.SW(Hc);if(typeof this._jsxZ3=="object"&&(new
Date()).valueOf()-this._jsxZ3.timestamp<200)return;var
P=this.doEvent("jsxbeforeresize",{objEVENT:r,intCOLUMNINDEX:Hc});if(!(P===false)){var
wb=this.WR();var
Xb=parseInt(s.style.left)-this.getScrollLeft();this._jsxresizeorigin={origin:Xb};wb.style.left=Xb+"px";Lb.ll(r,wb,function(h,l){return [h,0];});gc.subscribe("mouseup",this,"dY");}this._jsxZ3={timestamp:(new
Date()).valueOf()};r.cancelAll();};q._D=function(l,d){if(!l.leftButton())return;gc.publish(l);var
Nb=this.LL(Nb);Qb.trace("...still need logic here to find the widest cell and make the column exactly as wide, "+Nb);l.cancelAll();};q.LL=function(){return this._jsxp5;};q.SW=function(p){this._jsxp5=p;};q.WR=function(){return this.getRendered().childNodes[6];};q.yS=function(o){if(!o)o=this.getRendered();return o.childNodes[7];};q.f8=function(i){var
Cb=this.yS(i);Cb.style.display="none";Cb.removeAttribute("dropverb");Cb.removeAttribute("rowcontext");};q.dY=function(n){jsx3.EventHelp.reset();gc.unsubscribe("mouseup",this,"dY");if(parseInt(this.WR().style.left)!=this._jsxresizeorigin.origin){var
Cb=this.vx();var
Ob=jsx3.util.arrIndexOf(this.getChildren(),this.Xj()[this.LL()]);var
hc=this.doEvent("jsxafterresize",{objEVENT:n,vntWIDTH:Cb,intCOLUMNINDEX:Ob});if(!(hc===false))this.getChild(this.LL()).setWidth(Cb,true);this.fX();}this.WR().style.left="-6px";};q.vx=function(){var
fb=this.WR();var
u=parseInt(fb.style.left);var
Y=this.Xj();var
B=this.oD();var
U=this.getChild(this.LL()).getDisplayIndex();for(var
zb=0;zb<U;zb++)u=u-B[zb];u=u+this.getScrollLeft();return u<8?8:u;};q.getResizable=function(){return this.jsxresize;};q.setResizable=function(e){this.jsxresize=e;};q.S2=function(){this.FX();var
rb=this._O(true)/this.getRowsPerPanel(m.DEFAULT_ROWS_PER_PANEL);if(rb>parseInt(rb))rb=parseInt(rb)+1;this.I2(new
Array(rb));};q.JV=function(a,s){if(this.getParent()==null)return;this.pt();this.endEditSession();this.jB();this._L();this.WF();this.S2();var
pc=this.tY().length;var
V=this.getPagingModel(0);if(V==0||V==4){var
Ac={painted:1,token:m.getToken(),index:0};if(this.getRenderingModel()=="hierarchical")Ac.contextnodes=this.vE().childNodes;this.tY()[0]=Ac;this.pX(Ac,true);if(this.MR()){var
tb={painted:1,token:m.getToken(),index:-1};this.pX(tb,true);}}else{this.vE().innerHTML="";if(V==3){if(this.TP(this.tY().length-1))this.N_().unshift({index:pc-1});if(this.TP(0))this.N_().unshift({index:0});this.MT();}else if(V==2){for(var
ub=0;ub<pc;ub++)this.N_().push({index:ub});if(this.MR()==2){this.N_().unshift({index:-1});}else if(this.MR()==1)this.N_().push({index:-1});this.MT();}else if(V==1){this.N_().unshift({index:0});if(this.MR()==2){this.N_().unshift({index:-1});}else if(this.MR()==1)this.N_().push({index:-1});this.MT();}if(!s){var
hc=this.Vw(false);if(hc){var
M=this.vE();if(M.lastChild)jsx3.html.insertAdjacentHTML(M.lastChild,"BeforeEnd",hc);else M.innerHTML=hc;}}}if(a!==false)this.fX();};q.MR=function(){return this.getPagingModel()==3||this.getRenderingModel()=="hierarchical"?0:this.getAutoRow();};q.getAutoRow=function(){return this.jsxautorow;};q.setAutoRow=function(b){this.jsxautorow=b;};q.IO=function(){if(this.getPagingModel()==3){var
sc=this.tY();var
ab=this.vE().childNodes.length;var
V=this.getPanelPoolSize(m.DEFAULT_PANEL_POOL_COUNT);var
H=ab-V;if(H>0){Qb.trace("Panel pool max ("+V+") exceeded by: "+H);var
gb=this.bD();var
Gb=sc.length;if(Gb/2>gb){H=this.RQ(sc,Gb-1,gb+1,H,-1);if(H<=0)return;H=this.RQ(sc,0,gb-1,H,1);if(H<=0)return;}else{H=this.RQ(sc,0,gb-1,H,1);if(H<=0)return;H=this.RQ(sc,Gb-1,gb+1,H,-1);if(H<=0)return;}}}};q.RQ=function(o,i,p,c,d){for(var
fb=i;d==-1&&fb>p||d==1&&fb<p;fb=fb+d){if(o[fb]!=null){o[fb]=null;c--;Qb.trace("reaping panel: "+fb);var
W=this.HB(fb);if(W)W.parentNode.removeChild(W);}if(c<=0)return 0;}return c;};q.nJ=function(){var
H=this.vE();var
fb=H.childNodes;for(var
Y=0;Y<fb.length;Y++)if(fb[Y].tagName.toLowerCase()=="table"&&fb[Y].getAttribute("jsxautorow")!="true"||this.getRenderingModel()=="hierarchical"&&fb[Y].getAttribute("jsxtype")=="structure")return this.getRenderingModel()=="hierarchical"?fb[Y].firstChild:fb[Y];};q.CW=function(){var
Kb=this.vE();var
pb=Kb.childNodes;for(var
M=pb.length-1;M>=0;M--)if(pb[M].tagName.toLowerCase()=="table"&&pb[M].getAttribute("jsxautorow")!="true"||this.getRenderingModel()=="hierarchical"&&pb[M].getAttribute("jsxtype")=="structure")return this.getRenderingModel()=="hierarchical"?pb[M].firstChild:pb[M];};q.IU=function(){return this.HB(-1);};q.HB=function(f){var
Kc=this.getDocument();return Kc.getElementById(this.getId()+"jsx_"+f);};q.F8=function(h){return parseInt((h.id+"").replace(this.getId()+"jsx_",""));};q.GA=function(a){if(a.parentNode.tagName.toLowerCase()=="table")return a.parentNode;return a.parentNode.parentNode;};q._I=function(c,j){if(!isNaN(c))c=this.HB(c);if(c){var
ac=0;for(var
D=0;D<c.childNodes.length;D++)if(c.childNodes[D].tagName.toLowerCase()=="tbody"){return c.childNodes[D].childNodes[j];}else if(c.childNodes[D].tagName.toLowerCase()=="tr"){return c.childNodes[j+ac];}else ac++;}return null;};q.iN=function(l){var
Mc=this.getId()+"_jsx_"+l;var
Tb=this.getDocument();return Tb.getElementById(Mc);};q.cK=function(h){var
Ic=this.iN(h);return Ic?this.GA(this.iN(h)).parentNode:null;};q.av=function(p,g){var
_=this.Xj();for(var
gb=0;gb<_.length;gb++)if(_[gb].getPath()==g){var
eb=this.getId()+"_jsx_"+p+"_jsx_"+gb;var
hb=this.getDocument();return hb.getElementById(eb);}return null;};q.jP=function(s,i){var
kc=this.iN(s);return kc?kc.childNodes[i]:null;};q.Vq=function(){var
ec=this._I(0,0);return ec?ec.childNodes[0]:null;};q.mJ=function(p){return this._I(p,0);};q.ZI=function(p){var
Q=this._I(p,0);return Q?Q.parentNode.lastChild:null;};q.ZQ=function(d,i){this.collapseEditSession(d,i);};q.vF=function(j,c){this.collapseEditSession(j,c);};q.g6=function(k,b){var
Hb=b.parentNode;var
Jb=Hb.childNodes[0].childNodes[0];var
wb=Hb.childNodes[1].childNodes[0];var
t=b.scrollLeft;Hb.childNodes[1].scrollLeft=0;Jb.style.left="-"+t+"px";wb.style.left="-"+t+"px";if(k)this.doEvent("jsxscroll",{objEVENT:k,strDIRECTION:"horizontal",intPOSITION:t});};q.EL=function(p,i){var
pb=this.vE(i.parentNode);pb.parentNode.scrollTop=0;this._jsxAD=i.scrollTop;pb.style.top="-"+this._jsxAD+"px";var
_=this.bD();if(this.getPagingModel(0)==3){var
zb=this.getScrollInfoLabel(this.wj("jsx3.gui.Matrix.seek"));if(zb!=""){this.i6(i.parentNode).style.display="block";window.clearTimeout(this._jsxDX);var
cb=this;this._jsxDX=window.setTimeout(function(){if(i&&i.parentNode)cb.i6(i.parentNode).style.display="none";},1000);jsx3.sleep(function(){if(this.getParent()==null)return;if(i&&i.parentNode){var
hc=this.getRowHeight(m.DEFAULT_ROW_HEIGHT);var
zc=parseInt(this._jsxAD/hc)+1;var
M=this.vi(true).Zh();var
Vb=this._O();var
G=zc+parseInt(M/hc)-1;if(G>Vb)G=Vb;var
t=new
jsx3.util.MessageFormat(zb);this.i6(i.parentNode).childNodes[0].innerHTML=t.format(zc,G,Vb);}},"Matrix_timeout"+this.getId(),this);}var
Mb;var
cc=this.getPanelQueueSize(m.DEFAULT_PANEL_QUEUE_SIZE);var
Cc=parseInt(cc/2);var
rc=cc-Cc;for(var
qc=_+rc;qc>=_-Cc;qc--)if(this.TP(qc)!=null){this.N_().unshift({index:qc});if(this.N_().length>cc)var
Ob=this.N_().pop();Mb=true;}if(Mb)this.MT(pb);}this.doEvent("jsxscroll",{objEVENT:p,strDIRECTION:"vertical",intPOSITION:this._jsxAD});};q.i6=function(e){return e.childNodes[5];};q.bD=function(){return parseInt(this._jsxAD/(this.getRowsPerPanel(m.DEFAULT_ROWS_PER_PANEL)*this.getRowHeight(m.DEFAULT_ROW_HEIGHT)));};q.MT=function(f){jsx3.sleep(function(){if(this.getParent()==null)return;if(this.N_().length){var
nb=this.N_().shift();if(this.TP(nb.index))this.fA(this.JW(nb.index),f,nb.index);if(this.N_().length)this.MT(f);}},"MT"+this.getId(),this);};q.N_=function(){return this._jsxiV;};q.FX=function(){this._jsxiV=[];};q.fA=function(o,b,d){if(!b)b=this.vE();if(b){var
ub={index:d,painted:1,token:m.getToken()};this.tY()[d]=ub;Qb.trace("fetching panel: "+d);jsx3.html.insertAdjacentHTML(b,"BeforeEnd",o);this.pX(ub);this.QR(b);var
D=this;window.setTimeout(function(){if(D.getParent()==null)return;D.IO();},this.getReaperInterval(m.DEFAULT_REAPER_INTERVAL));}};q.getIterableRows=function(){var
wb,jc;var
ob=[];jc=this.getRendered();if(jc)if(this.getRenderingModel()=="hierarchical"){var
J=this.getRenderingContext("jsxroot");var
fb=this.getRecordNode(J);var
Vb=[];for(var
oc=fb.selectNodeIterator("./record");oc.hasNext();){var
Dc=oc.next();var
vb=Dc.getAttribute("jsxid");Vb.push(this.cK(vb));}ob=this.EI({contextnodes:Vb});}else{var
M=jc.childNodes[1].childNodes[0].childNodes;var
S;for(var
oc=0;oc<M.length;oc++){S=M[oc];S=this.mJ(S);if(S){S=S.parentNode;var
yb=S.childNodes.length;for(var
F=0;F<yb;F++){var
lc=S.childNodes[F];if(lc.tagName.toLowerCase()=="tr")ob.push(lc);}}}}return ob;};q.EI=function(f){var
F=[];if(f.contextnodes){for(var
Hc=0;Hc<f.contextnodes.length;Hc++)if(f.contextnodes[Hc].getAttribute("jsxtype")=="structure")F.push.apply(F,this.xC(f.contextnodes[Hc]));}else{var
sc=f.index;var
ib=this.HB(sc);if(ib){ib=this.mJ(ib);if(ib){ib=ib.parentNode;var
Jb=ib.childNodes.length;for(var
Gb=0;Gb<Jb;Gb++){var
ic=ib.childNodes[Gb];if(ic.tagName.toLowerCase()=="tr")F.push(ic);}}}}return F;};q.xC=function(c,e){if(e==null)e=[];e.push(this.mJ(c.firstChild));if(c.lastChild){var
yb=c.lastChild.childNodes;for(var
jc=0;jc<yb.length;jc++)if(yb[jc].tagName)this.xC(yb[jc],e);}return e;};m.mX=0;m.getToken=function(){m.mX+=1;return m.mX;};q.getContentElement=function(l,c){var
sc=this.av(l,c);if(sc)if(sc.cellIndex==0&&this.getRenderingModel()=="hierarchical"&&this.getRenderNavigators(1)!=0){var
D=sc.childNodes[0].childNodes[0];while(D&&D.tagName.toLowerCase()!="tr")D=D.childNodes[0];if(D)return D.lastChild;}else return sc.childNodes[0];};q.pX=function(b,d){this._jsxrQ=[];if(this._O()==0&&!this.MR())return;var
Zb=this.getServer();var
rc=this.Xj();var
vb=new
Array(rc.length);var
I=false;for(var
wc=0;wc<rc.length;wc++){var
db=rc[wc].vk();if(db){vb[wc]=db;I=true;}}if(!I)return;var
ab=this.EI(b);if(b.contextnodes){b.index=true;delete b.contextnodes;}var
D=ab.length;var
tc=this.getRenderingModel()=="hierarchical"&&this.getRenderNavigators(1)!=0;var
Wb=[];for(var
wc=0;wc<rc.length;wc++){var
db=vb[wc];if(db)Wb.push([wc,db,rc[wc]]);}for(var
Pb=0;Pb<D;Pb++){var
J=ab[Pb];var
hb=J.getAttribute("jsxid");var
Y=J.getAttribute("jsxrownumber");for(var
dc=0;dc<Wb.length;dc++){var
Nb=null;var
wc=Wb[dc][0];var
db=Wb[dc][1];var
Z=Wb[dc][2];if(tc&&wc==0){var
U=J.childNodes[0].childNodes[0].childNodes[0];while(U&&U.tagName.toLowerCase()!="tr")U=U.childNodes[0];if(U)Nb=U.lastChild;}else if(J.childNodes[wc])Nb=J.childNodes[wc].childNodes[0];if(Nb)if(d){db.format(Nb,hb,this,Z,Y,Zb);}else this.IN(db,Nb,hb,Z,Y,b);}}};q.IN=function(e,k,c,p,j,a){var
Pb=this._jsxrQ;if(Pb.length==0)jsx3.sleep(this.kt,"Matrix2pass"+this.getId(),this);Pb[Pb.length]=[e,k,c,p,j,a];};q.kt=function(){if(this.getParent()==null){this._jsxrQ=[];return;}var
gb=this.getServer();var
rc=(new
Date()).getTime();var
Cb=rc;while(this._jsxrQ.length>0&&Cb-rc<m.w6){var
ac=this._jsxrQ.shift();var
Mc=ac[5];var
Nb=Mc.index;if(!Nb){var
_=this.tY()[Mc.index];Nb=_!=null&&_.token==Mc.token;}if(Nb){ac[0].format(ac[1],ac[2],this,ac[3],ac[4],gb);Cb=(new
Date()).getTime();}}if(this._jsxrQ.length>0)jsx3.sleep(this.kt,"Matrix2pass"+this.getId(),this);};q.vE=function(h){if(!h)h=this.getRendered();return h?h.childNodes[1].childNodes[0]:null;};q.Xu=function(){var
K=this.getPagingModel(0);var
Y=null;if(K==3){Y=this._O()*this.getRowHeight(m.DEFAULT_ROW_HEIGHT);}else{var
B=this.vE();Y=B?parseInt(B.offsetHeight):0;}return Y;};q.TP=function(s){if(s==-1||s>=0&&s<this.tY().length&&this.tY()[s]==null){var
cb=this.getDocument();var
w=cb.getElementById(this.getId()+"jsx_"+s);return !w;}return false;};q.JW=function(r){var
_=this.vi(true);var
wb=this.getRowsPerPanel(m.DEFAULT_ROWS_PER_PANEL);var
Vb=this.getPagingModel(0);if(Vb==3){var
G=this.getRowHeight(m.DEFAULT_ROW_HEIGHT);var
O="position:absolute;left:0px;top:"+wb*G*r+"px;";var
rb=wb*r;var
Lc=rb+wb+1;}else{var
O="position:relative;";var
Y="";if(Vb==2){var
rb=wb*r;var
Lc=rb+wb+1;}else{var
eb=this._O();var
rb=0;var
Lc=eb+1;}}var
Bb={};Bb.jsx_min_exclusive=rb;Bb.jsx_max_exclusive=Lc;Bb.jsx_panel_index=r;Bb.jsx_panel_css=O;Bb.jsx_column_widths=this.b6();Bb.jsx_rendering_context=this.getRenderingContext("jsxroot");Bb.jsx_mode=r==-1?"autorow":"panel";Qb.trace("Fetching records: "+rb+" - to - "+Lc);return this.doTransform(Bb);};q.resetXmlCacheData=function(g){this.nk(true);this.jsxsupermix(g);};q.setXMLId=function(k){this.nk(true);return this.jsxsupermix(k);};q.repaint=function(){this.nk(true);return this.jsxsuper();};q.setXMLString=function(k){this.nk(true);return this.jsxsupermix(k);};q.setXMLURL=function(n){this.nk(true);return this.jsxsupermix(n);};q.getXSL=function(){return this.yl();};q.yl=function(g){var
nb=jsx3.getSharedCache().getOrOpenDocument(m.DEFAULTXSLURL,null,jsx3.xml.XslDocument.jsxclass);if(g)return nb;var
ib=this.getServer().getCache();var
lb=ib.getDocument(this.getXSLId());if(lb==null){lb=nb.cloneDocument();ib.setDocument(this.getXSLId(),lb);var
S=this.getRenderingModel("deep");var
Jb=this.Xj();var
ab=lb.selectSingleNode("//xsl:template[@name='row_template']//tr");var
Q=lb.selectSingleNode("//xsl:template[@name='row_template']//tr/xsl:choose/xsl:when");var
Hb=lb.selectSingleNode("//xsl:choose/xsl:when/xsl:choose");var
M=this.b6();for(var
U=0;U<Jb.length;U++){var
Zb=Jb[U];var
Mb=Zb.vi(true).tp(1);var
Bc=Mb.tp(0);var
Pb=this.vo()+this.cn("focus","CH")+this.cn("blur","tI");var
Xb=U==0&&S=="hierarchical"?' colspan="{$jsx_colspan}" jsxcolspan="{$jsx_colspan}" ':"";Mb.setAttributes(Pb+Xb+' jsxtype="cell" class="jsx30matrixcolumn_cell" unselectable="on" id="{$jsx_id}_jsx_{$jsx_cdfkey}_jsx_'+U+'"');Mb.setStyles(Zb.Nk()+Zb.hd()+Zb.Lk()+Zb.Of()+Zb.rl()+Zb.He()+Zb.jj()+"{$jsx_selection_bg}{$jsx_rowbg}");Bc.setAttributes('class="jsx30matrixcolumn_cell_value" unselectable="on"');Bc.setStyles(Zb.Vn()+Zb.Qe());var
mb=m.UC.format(Zb.getId()+"_value");var
wb=new
jsx3.xml.Document();wb.loadXML(mb);if(!wb.hasError())Hb.appendChild(wb.getRootNode());if(S=="hierarchical"&&U==0&&this.getRenderNavigators(1)!=0){var
H=m.yP.format("ui_controller");var
ub=lb.selectSingleNode("//xsl:template[@name='ui_controller']//xsl:call-template");ub.setAttribute("name",Zb.getId()+"_value");}else var
H=m.yP.format(Zb.getId()+"_value");var
X="";var
y=Zb.getEditMask();if(y!=null&&this.ZK(y)&&y.emGetType()==m.EditMask.FORMAT)X=y.emPaintTemplate().replace(/\{0\}/g,"@"+Zb.getPath());var
H=Mb.paint().join(Bc.paint().join(H));var
gb=/width:\d*px;/;var
Fc=H.match(gb);var
qc=m.sz.format(Zb.getId(),H,"##JSX_REPLACE##");var
Kb=(Fc+"").split(":");var
Wb=parseInt(Kb[1]);var
N=U==0?M-this.oD()[0]+Wb:Wb;qc=qc.replace(Fc,"{$jsx_first_row_width_style}").replace("##JSX_REPLACE##","'"+Wb+"'").replace("##JSX_REPLACE_ALL##",N);wb=new
jsx3.xml.Document();wb.loadXML(qc);if(!wb.hasError())lb.getRootNode().appendChild(wb.getRootNode());var
G=Zb.getValueTemplate(m.Column.TEMPLATES["default"]).replace(/\{0\}/g,"@"+Zb.getPath());wb=new
jsx3.xml.Document();wb.loadXML(G);if(!wb.hasError()){wb.getRootNode().setAttribute("name",Zb.getId()+"_value");lb.getRootNode().appendChild(wb.getRootNode());}if(X!=""){wb=new
jsx3.xml.Document();wb.loadXML(X);if(!wb.hasError()){var
_b=lb.selectSingleNode("//xsl:template[@name='"+Zb.getId()+"_value']");_b.appendChild(wb.getRootNode());}else Qb.error("Could not create valid XSLT for the edit mask owned by the column, '"+Zb.getId()+"':\n\t"+wb.getError());}var
t=m.W0.format(Zb.getId());wb=new
jsx3.xml.Document();wb.loadXML(t);if(!wb.hasError())if(U==0)ab.insertBefore(wb.getRootNode(),Q.getParent());else Q.appendChild(wb.getRootNode());}}return lb;};m.yK=function(h){return h&&h.getDisplay()!="none";};q.Xj=function(){return this.getChildren().filter(m.yK);};q.doTransform=function(n){if(!n)n={};n.jsx_id=this.getId();n.jsx_rendering_model=this.getRenderingModel("deep");n.jsx_paging_model=this.getPagingModel(0);var
C=this.getUriResolver();if(n.jsx_rendering_model=="hierarchical"){var
z=this.getIcon(m.ICON),H=this.getIconMinus(m.ICON_MINUS),Fc=this.getIconPlus(m.ICON_PLUS);if(n.jsx_icon==null)n.jsx_icon=z?C.resolveURI(z):"";if(n.jsx_icon_minus==null)n.jsx_icon_minus=H?C.resolveURI(H):"";if(n.jsx_icon_plus==null)n.jsx_icon_plus=Fc?C.resolveURI(Fc):"";n.jsx_transparent_image=Yb.SPACE;}n.jsx_sort_path=this.getSortPath();n.jsx_sort_direction=this.getSortDirection();n.jsx_sort_type=this.getSortType();n.jsx_selection_model=this.getSelectionModel(1);n.jsx_selection_bg_url=this.uL();var
Ic=this.getXSLParams();for(var tb in Ic)n[tb]=Ic[tb];if(n.jsx_use_categories&&this.getRenderingModel()!="hierarchical")delete n.jsx_use_categories;n.jsx_column_count=this.Xj().length;n.jsxpath=jsx3.getEnv("jsxabspath");n.jsxpathapps=jsx3.getEnv("jsxhomepath");n.jsxpathprefix=this.getUriResolver().getUriPrefix();var
lb=this.jsxsupermix(n);lb=this.yp(lb);return !n.jsx_return_at_all_costs&&lb.indexOf("<tr")==-1?"":lb;};q.nk=function(i){if(!this.getServer())return;delete this._jsxB7;if(!i){this.resetXslCacheData();this.qo(true);delete this._jsxSW;}};q.getSortedIds=function(){var
Bb=this.doTransform({jsx_mode:"sort",jsx_return_at_all_costs:true});return Bb.search(/<ids>([\s\S]*)\s*,\s*<\/ids>/)>-1?window.eval("["+RegExp.$1+"]"):[];};q._O=function(n){if(n)delete this._jsxB7;if(this._jsxB7){return this._jsxB7.maxlen;}else{var
Bc={};Bc.jsx_mode="count";Bc.jsx_rendering_model=this.getRenderingModel("deep");Bc.jsx_rendering_context=this.getRenderingContext("jsxroot");var
db=this.yl(true);db.reset();db.setParams(Bc);var
S=db.transform(this.getXML());var
gb=S.search(/(\d+)/)>-1?parseInt(RegExp.$1):0;Qb.trace("Getting Record Count: "+gb);this._jsxB7={maxlen:gb};if(this.getPagingModel()==3){var
Sb=this.vi();var
Fb=this.getRendered();if(Sb&&Fb){Sb=Sb.tp(2).tp(0);var
Mb=this.getRowHeight(m.DEFAULT_ROW_HEIGHT)*gb;Sb.recalculate({height:Mb+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)},Fb.childNodes[2].childNodes[0],null);}}return gb;}};q.tY=function(){return this._jsxcO;};q.I2=function(a){this._jsxcO=a;};q.getSelectionModel=function(b){return this.jsxselectionmodel!=null?this.jsxselectionmodel>2?0:this.jsxselectionmodel:b!=null?b:null;};q.setSelectionModel=function(d){this.jsxselectionmodel=d;};q.getRowHeight=function(d){return this.jsxrowheight!=null?this.jsxrowheight:d!=null?d:null;};q.setRowHeight=function(c,k){this.jsxrowheight=c;this.nk();if(!k)this.repaint();};q.getRowsPerPanel=function(n){return this.jsxrowsperpanel?this.jsxrowsperpanel:n?n:null;};q.setRowsPerPanel=function(i,f){this.jsxrowsperpanel=i;this.nk(true);if(!f)this.repaint();};q.getPanelQueueSize=function(k){return this.jsxpaintqueuesize?this.jsxpaintqueuesize:k?k:null;};q.setPanelQueueSize=function(l){this.jsxpaintqueuesize=l;};q.getReaperInterval=function(a){return this.jsxreaperinterval?this.jsxreaperinterval:a?a:null;};q.setReaperInterval=function(e){this.jsxreaperinterval=e;};q.getPanelPoolSize=function(l){return this.jsxpanelpoolsize?this.jsxpanelpoolsize:l?l:null;};q.setPanelPoolSize=function(g){this.jsxpanelpoolsize=g;this.nk(true);};q.getPagingModel=function(h){if(this.getRenderingModel()=="hierarchical"&&this.jsxpagingmodel!=4){Qb.trace("The paging model was overridden (disabled) because the rendering mode is hierarchical and stepped paging was not explicitly set.");return 0;}return !isNaN(this.jsxpagingmodel)?this.jsxpagingmodel:!isNaN(h)?h:null;};q.setPagingModel=function(r){this.jsxpagingmodel=r;this.nk();};q.getHeaderHeight=function(o){return this.jsxheaderheight!=null?Number(this.jsxheaderheight):o?o:null;};q.setHeaderHeight=function(n,s){this.jsxheaderheight=n;this.qo(true);if(!s)this.repaint();};q.getScrollInfoLabel=function(f){return this.jsxscrollinfolabel!=null?this.jsxscrollinfolabel:f?f:null;};q.setScrollInfoLabel=function(l){this.jsxscrollinfolabel=l;};q.getScrollLeft=function(){var
w=this.getRendered();return w?w.childNodes[3].scrollLeft:0;};q.setScrollLeft=function(n){var
T=this.getRendered();if(T&&T.childNodes[3]){T.childNodes[3].scrollLeft=n;if(T.childNodes[3].style.display=="none")this.g6(false,T.childNodes[3]);}};q.getScrollTop=function(){return this._jsxAD?this._jsxAD:0;};q.UM=function(){var
ec=this.getRendered();return ec&&ec.childNodes[2]?ec.childNodes[2].scrollTop:this.getScrollTop();};q.setScrollTop=function(p,h){if(p<0)p=0;h=this.getRendered(h);if(h&&h.childNodes[2]){if(h.childNodes[2].scrollTop==p==0)h.childNodes[2].scrollTop=1;h.childNodes[2].scrollTop=p;}};q.synchronizeVScroller=function(){this.QR();};q.QR=function(j){if(!j)j=this.vE();if(!j)return;if(this.getPagingModel()!=3){var
_=this.vi().tp(2).tp(0);_.recalculate({height:j.offsetHeight+this.getHeaderHeight(m.DEFAULT_HEADER_HEIGHT)},j.parentNode.parentNode.childNodes[2].childNodes[0],null);var
t=this.UM();if(this.getScrollTop()!=t){this.setScrollTop(t);j.style.top="-"+t+"px";}}if(j.parentNode.parentNode.childNodes[3].style.display=="none")this.setScrollLeft(0);this.wV();};q.wV=function(){var
K=this.getRendered();if(K)K.childNodes[4].style.display=this.getSuppressVScroller(0)==1?"none":"";};q.getScaleWidth=function(){return this.jsxscalewidth;};q.setScaleWidth=function(h){this.jsxscalewidth=h;this.fi();return this;};q.onSetChild=function(a){if(a instanceof m.Column){this.nk();return true;}return false;};q.paintChild=function(b,k){if(!k)this.repaint();};q.onRemoveChild=function(e,k){this.jsxsuper(e,k);this.nk();this.repaint();};q.getHeaderBorder=function(){return this.jsxheaderborder;};q.setHeaderBorder=function(k){this.jsxheaderborder=k;this.qo(true);this.repaintHead();};q.getBodyBorder=function(){return this.jsxbodyborder;};q.setBodyBorder=function(k,a){this.jsxbodyborder=k;this.nk();if(!a)this.repaint();};q.getValue=function(){var
J=this.getSelectionModel();if(J==2){return this.getSelectedIds();}else return this.getSelectedIds()[0];};q.doValidate=function(){var
K=this.getSelectedNodes().size()>0||this.getRequired()==0;this.setValidationState(K?1:0);return this.getValidationState();};q.getRenderingModel=function(s){return this.jsxrenderingmodel?this.jsxrenderingmodel:s?s:null;};q.setRenderingModel=function(r,d){this.jsxrenderingmodel=r;this.nk();if(!d)this.repaint();};q.getRenderingContext=function(k){return this.jsxrenderingcontext!=null&&this.jsxrenderingcontext!=""?this.jsxrenderingcontext:k!=null?k:null;};q.setRenderingContext=function(s,l){this.jsxrenderingcontext=s;this.nk(true);if(!l)this.repaint();};q.getSuppressHScroller=function(o){return this.jsxsuppresshscroll!=null?this.jsxsuppresshscroll:o!=null?o:null;};q.setSuppressHScroller=function(d){this.jsxsuppresshscroll=d;var
V=this.getRendered();if(V&&V.childNodes[3]){V.childNodes[3].style.display=d!=1?"block":"none";this.wV();}};q.getSuppressVScroller=function(f){return this.jsxsuppressvscroll!=null?this.jsxsuppressvscroll:f!=null?f:null;};q.setSuppressVScroller=function(g,a){this.jsxsuppressvscroll=g;this.nk();if(a){var
jb=this.getRendered();if(jb&&jb.childNodes[2]){jb.childNodes[2].style.display=g!=1?"block":"none";this.wV();}}else this.repaint();};q.getFixedColumnIndex=function(h){return this.jsxfixedcolumnindex!=null?this.jsxfixedcolumnindex:h!=null?h:null;};q.setFixedColumnIndex=function(k){this.jsxfixedcolumnindex=k;};q.getRenderNavigators=function(k){return this.jsxrendernavigators!=null?this.jsxrendernavigators:k!=null?k:null;};q.setRenderNavigators=function(s,n){this.jsxrendernavigators=s;this.nk();if(!n)this.repaint();};q.getIcon=function(b){return this.jsxicon!=null&&this.jsxicon!=""?this.jsxicon:b?b:null;};q.setIcon=function(k){this.jsxicon=k;};q.getIconMinus=function(s){return this.jsxiconminus!=null&&this.jsxiconminus!=""?this.jsxiconminus:s?s:null;};q.setIconMinus=function(i){this.jsxiconminus=i;};q.getIconPlus=function(i){return this.jsxiconplus!=null&&this.jsxiconplus!=""?this.jsxiconplus:i?i:null;};q.setIconPlus=function(o){this.jsxiconplus=o;};q.deleteRecord=function(l,g){var
wb=this.getXML();var
Gc=wb.selectSingleNode(this.Ef(l));if(Gc!=null){Gc=Gc.getParent().removeChild(Gc);if(g!==false){this.redrawRecord(l,0);if(this.getRenderingModel()!="hierarchical"){var
S=Gc.selectNodes(".//record");for(var
eb=S.size()-1;eb>=0;eb--){var
bc=S.get(eb);this.redrawRecord(bc.getAttribute("jsxid"),0);}}}return Gc;}return null;};q.insertRecordProperty=function(f,s,k,a){if(s=="jsxid"){var
fc=this.jsxsupermix(f,s,k,false);var
pc=this.iN(f);if(pc){pc.setAttribute("jsxid",k);pc.setAttribute("JSXDRAGID",k);var
eb=this.getId()+"_jsx_"+k;pc.setAttribute("id",eb);var
Nc=pc.childNodes;eb=eb+"_jsx_";for(var
Q=0;Q<Nc.length;Q++)Nc[Q].setAttribute("id",eb+Q);if(a!=false)this.redrawRecord(k,2);return fc;}}else return this.jsxsupermix(f,s,k,a);};q.redrawCell=function(l,b,n){var
eb=this.jP(l,b.getDisplayIndex());if(eb){var
M=eb.childNodes[0];if(this.getRenderingModel()=="hierarchical"&&b.getChildIndex()==0&&this.getRenderNavigators(1)!=0){while(M&&M.tagName.toLowerCase()!="tr")M=M.childNodes[0];if(M){M=M.lastChild;}else{Qb.error("redrawCell can not resolve the on-screen HTML element ot update");return;}}var
Y={};Y.jsx_return_at_all_costs=true;Y.jsx_mode="cellvalue";Y.jsx_record_context=l;Y.jsx_cell_value_template_id=b.getId()+"_value";var
nb=this.doTransform(Y);M.innerHTML=nb;var
zb=b.vk();if(zb){var
K=eb.parentNode;zb.format(M,K.getAttribute("jsxid"),this,b,K.getAttribute("jsxrownumber"),this.getServer());}if(!n){var
kc=this.Xj();var
Hb=new
RegExp("\\b("+b.getPath()+")\\b");for(var
bc=0;bc<kc.length;bc++){var
fc=kc[bc].getTriggers()+"";if(kc[bc]!=b&&(kc[bc].getPath()==b.getPath()||fc.search(Hb)>=0))this.redrawCell(l,kc[bc],true);}}}};q.redrawMappedCells=function(g,r){var
Mb=this.Xj();for(var
Hb=0;Hb<Mb.length;Hb++)if(Mb[Hb].getPath()==r){this.redrawCell(g,Mb[Hb],false);return;}};q.DP=function(i,r){return this.doTransform({jsx_mode:"record",jsx_panel_css:"position:relative;",jsx_column_widths:this.b6(),jsx_context_index:r?r:1,jsx_rendering_context:this.getRecordNode(i).getParent().getAttribute("jsxid"),jsx_rendering_context_child:i});};q.redrawRecord=function(r,j,h){var
mb=this.vE();if(r!=null&&j==2){if(this.getRenderingModel()=="hierarchical"){var
G=this.cK(r);var
tb=G.parentNode;var
Vb=this.DP(r,tb.getAttribute("jsxcontextindex"));jsx3.html.setOuterHTML(G,Vb);G=this.cK(r);var
Ub={painted:1,token:m.getToken(),contextnodes:[G]};this.tY()[0]=Ub;this.pX(Ub);}else{var
u=this.Xj();for(var
C=0;C<u.length;C++)this.redrawCell(r,u[C],true);}}else if(r!=null&&j==0){if(this.getRenderingModel()=="hierarchical"){var
sb=this.cK(r);if(sb){var
Tb=sb.parentNode;Tb.removeChild(sb);if(Tb.childNodes.length==0){var
Ab=Tb.previousSibling;var
fc=this.mJ(Ab);if(fc){var
Hc=fc.getAttribute("jsxid");this.redrawRecord(Hc,2);}}this.QR();}}else if(this.getPagingModel(0)!=3){var
sb=this.iN(r);if(sb){var
Db=sb.parentNode;if(Db.childNodes.length==1){if(Db.tagName.toLowerCase()!="table")Db=Db.parentNode;Db.parentNode.removeChild(Db);}else{var
Fb=sb.nextSibling;if(sb.parentNode.firstChild==sb&&Fb)for(var
C=0;C<sb.childNodes.length;C++)Fb.childNodes[C].style.width=sb.childNodes[C].style.width;sb.parentNode.removeChild(sb);this.QR();}}}else this.repaint();}else if(r!=null&&j==3){if(this.getPagingModel(0)!=3){var
kc=this.getRecordNode(r);var
T=kc.getNextSibling();var
jb=T.getAttribute("jsxid");if(this.getRenderingModel()=="hierarchical"){var
Ic=this.cK(jb);var
Vb=this.DP(r,Ic.parentNode.getAttribute("jsxcontextindex"));jsx3.html.insertAdjacentHTML(Ic,"BeforeBegin",Vb);var
Ub={painted:1,token:m.getToken(),contextnodes:[Ic.previousSibling]};this.tY()[0]=Ub;this.pX(Ub);this.QR(mb);}else{var
uc=this.iN(jb);var
V=uc.parentNode;var
zb=this.TZ(V,r);V.insertBefore(zb,uc);if(V.firstChild==zb)for(var
C=0;C<zb.childNodes.length;C++){zb.childNodes[C].style.width=uc.childNodes[C].style.width;uc.childNodes[C].style.width="";}this.hv(zb,r);this.QR(mb);if(h!==false)this.kW(kc);}}else this.repaint();}else if(r!=null&&j==1)if(this.getPagingModel(0)!=3){if(this.getRenderingModel()=="hierarchical"){var
Ob=this.getRecordNode(r).getParent().getAttribute("jsxid");var
G=this.cK(Ob);var
tb=G.lastChild;if(this.G0(tb)){this.toggleItem(Ob,true);}else{var
Vb=this.DP(r,tb.getAttribute("jsxcontextindex"));jsx3.html.insertAdjacentHTML(tb,"BeforeEnd",Vb);var
Ub={painted:1,token:m.getToken(),contextnodes:[tb.lastChild]};this.tY()[0]=Ub;this.pX(Ub);this.QR(mb);}}else{var
V=this.CW();if(V==null||V.firstChild==null){this.repaintData();}else{if(V.firstChild.tagName.toLowerCase()=="tbody")V=V.firstChild;var
zb=this.TZ(V,r);V.appendChild(zb);this.hv(zb,r);this.QR(mb);if(h!==false)this.kW(this.getRecordNode(r));}}}else this.repaint();};q.kW=function(g){if(this.getRenderingModel("deep")=="deep"){var
ac=g.selectNodeIterator(".//record");while(ac.hasNext()){g=ac.next();this.redrawRecord(g.getAttribute("jsxid"),1,false);}}};q.G0=function(s){return s.childNodes.length==0||s.childNodes.length==1&&s.childNodes[0].nodeType!=1;};q.hv=function(n,b){var
v=this.Xj();for(var
Nb=0;Nb<v.length;Nb++){var
z=v[Nb];var
zc=z.vk();if(zc){var
Vb=n.childNodes[Nb].childNodes[0];zc.format(Vb,b,this,z,n.getAttribute("jsxrownumber"),this.getServer());}}};q.TZ=function(a,f){var
fb=this.getDocument();var
gb={};gb.jsx_column_widths=this.b6();gb.jsx_rendering_context=this.getRecordNode(f).getParent().getAttribute("jsxid");gb.jsx_rendering_context_child=f;gb.jsx_mode="record";var
Ab=this.doTransform(gb);var
eb=new
jsx3.xml.Document();eb.loadXML(Ab);var
hb=eb.getRootNode();var
Xb=fb.createElement("tr");m.dP(hb,Xb);for(var
V=hb.getChildIterator();V.hasNext();){hb=V.next();var
cb=fb.createElement("td");m.dP(hb,cb);Xb.appendChild(cb);cb.innerHTML=hb.getFirstChild().getXML();}return Xb;};m.dP=function(j,d){var
kb=j.getAttributeNames();for(var
Vb=0;Vb<kb.length;Vb++){var
sc=kb[Vb];var
ac=j.getAttribute(sc);var
Sb=/^(on(?:mousedown|click|focus|blur|mouseup|mouseover|mouseout|dblclick|scroll|keydown|keypress))/i;if(sc.match(Sb)){jsx3.html.addEventListener(d,sc.toLowerCase(),ac);}else if(sc=="class"){d.className=ac;}else if(sc=="style"){jsx3.gui.Painted.Be(d,ac);}else d.setAttribute(sc,ac);}};q.setValue=function(b){this.deselectAllRecords();if(b){if(b instanceof Array){if(this.getSelectionModel()!=2&&b.length>1)throw new
jsx3.IllegalArgumentException("strId",b);}else b=[b];for(var
v=0;v<b.length;v++)this.selectRecord(b[v]);this.revealRecord(b[0]);}else{this.synchronizeVScroller();this.setScrollTop(0);}return this;};q.getMaskProperties=function(){return Yb.MASK_NO_EDIT;};q.onDestroy=function(d){this.jsxsuper(d);this.onDestroyCached(d);};});jsx3.Class.defineClass("jsx3.gui.Matrix.ColumnFormat",null,null,function(i,r){var
kc=jsx3.gui.Matrix;i.q_={medium:2,full:4};i.q_["short"]=1;i.q_["long"]=3;i.gQ={integer:1,percent:1,currency:1};i.l7={unescape:"VX",unescape_all:"hE",lookup:"HE"};i.getInstance=function(a,h){var
nb=null;var
Nb=null;if(a.charAt(0)=="@"&&(Nb=i.l7[a.substring(1)])!=null){nb=new
i();nb.format=i[Nb];}else if(a.match(/^@(datetime|date|time|number)\b/)){nb=new
kc.MessageFormat(h,"{0,"+a.substring(1)+"}");}else if(a.indexOf("@message")==0)nb=new
kc.MessageFormat(h,a.substring(9));return nb;};r.init=function(){};r.validate=function(){return true;};r.format=jsx3.Method.newAbstract("objDiv","strCDFKey","objMatrix","objMatrixColumn","intRowNumber","objServer");i.VX=function(p,q,l,k,j,m){i.hE(p,q,l,k,j,m,jsx3.xml.Template.supports(1));};i.hE=function(f,h,b,o,s,d,m){if(!m)f.innerHTML=f.innerHTML.replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&quot;/g,'"').replace(/&amp;/g,"&");};i.HE=function(c,k,s,e,p,g){var
zb=e.getEditMask();if(zb&&zb.OL)zb=zb.OL();if(zb!=null&&typeof zb.getRecordNode=="function"){var
z=s.getRecordNode(k);if(z){var
uc=e.getValueForRecord(k);var
Ec=zb.getRecordNode(uc);c.innerHTML=Ec!=null?Ec.getAttribute("jsxtext"):uc!=null?jsx3.util.strEscapeHTML(uc):"";}}};});jsx3.Class.defineClass("jsx3.gui.Matrix.MessageFormat",jsx3.gui.Matrix.ColumnFormat,null,function(d,q){q.init=function(e,p){this.QM=new
jsx3.util.MessageFormat(p,e.getServer().getLocale());};q.format=function(i,e,g,r,c,a){var
Ob=r.getValueForRecord(e);if(Ob)try{i.innerHTML=this.QM.format(Ob);}catch(Kc){jsx3.util.Logger.GLOBAL.error(this.QM,jsx3.NativeError.wrap(Kc));}};});jsx3.Class.defineInterface("jsx3.gui.Matrix.EditMask",null,function(h,o){var
cc=jsx3.gui.Matrix;h.NORMAL=1;h.FORMAT=2;h.DIALOG=3;o.emInit=function(e){};o.emGetType=function(){return h.NORMAL;};o.emPaintTemplate=function(){return this.paint();};o.cC=function(i,f,r,n,p,q,d){this._jsxl8={matrix:n,column:p,recordId:q,td:d,value:i};return this.emBeginEdit(i,f,r,n,p,q,d)!==false;};o.emBeginEdit=function(l,c,q,m,g,a,j){};o.Z0=function(){var
tb=this.emEndEdit();delete this._jsxl8;return tb;};o.emEndEdit=function(){return this.emGetValue();};o.emGetValue=function(){return null;};o.suspendEditSession=function(){this.getAncestorOfType(cc)._jsxON.f2=true;};o.resumeEditSession=function(){this.getAncestorOfType(cc)._jsxON.f2=false;};o.emGetSession=function(){return this._jsxl8;};o.commitEditMask=function(i,q){if(this._jsxl8)this._jsxl8.matrix.K8(i,q);};o.emCollapseEdit=function(n){};});jsx3.Class.defineInterface("jsx3.gui.Matrix.BlockMask",jsx3.gui.Matrix.EditMask,function(o,b){var
fc=jsx3.gui.Matrix;var
Xb=jsx3.gui.Block;b.emInit=function(i){this.setDisplay("none",true);this.setLeft(0,true);this.setTop(0,true);this.setRelativePosition(0,true);};b.emGetType=function(){return fc.EditMask.NORMAL;};b.emBeginEdit=function(j,e,s,n,a,r,c){this.setLeft(e.L,true);this.setTop(e.T,true);if(isNaN(this.getWidth()))this.setWidth(e.W,true);if(isNaN(this.getHeight()))this.setHeight(e.H,true);this.setDisplay("",true);this.setMaskValue(j);var
lc=this.getMaskFirstResponder()||this;lc.focus();};b.emGetValue=function(){return this.getMaskValue();};b.getMaskFirstResponder=function(){return this.OL();};b.getMaskValue=function(){var
Zb=this.OL();return Zb!=null?Zb.getValue():null;};b.setMaskValue=function(s){var
zc=this.OL();if(zc!=null)zc.setValue(s);};b.OL=function(){return this.getDescendantsOfType(jsx3.gui.Form)[0];};b.emEndEdit=function(){var
Ic=this.getMaskValue();this.setDisplay("none",true);return Ic;};});jsx3.Class.defineInterface("jsx3.gui.Matrix.DialogMask",jsx3.gui.Matrix.BlockMask,function(j,i){var
S=jsx3.gui.Matrix;i.emInit=function(b){S.BlockMask.prototype.emInit.call(this,b);var
Vb=this.getParent();while(Vb!=null){if(jsx3.gui.Window&&Vb instanceof jsx3.gui.Window){Vb=Vb.getRootBlock();break;}else if(jsx3.gui.Dialog&&Vb instanceof jsx3.gui.Dialog)break;Vb=Vb.getParent();}if(Vb==null)Vb=this.getServer().getRootBlock();Vb.paintChild(this);};i.emGetType=function(){return S.EditMask.DIALOG;};i.emBeginEdit=function(g,h,f,l,r,o,k){this._jsxl8={matrix:l,column:r,recordId:o,td:k};if(this.getLeft()==0&&this.getTop()==0){var
P=jsx3.html.getRelativePosition(this.getRendered(k).parentNode,k);this.setLeft(P.L,true);this.setTop(P.T+P.H,true);}this.setDisplay("",true);this.setMaskValue(g);var
dc=this.getMaskFirstResponder()||this;dc.focus();};i.OL=function(){var
Tb=this.getChild(0)==this.getCaptionBar()?this.getChild(1):this.getChild(0);return Tb!=null?Tb.getDescendantsOfType(jsx3.gui.Form)[0]:null;};});
