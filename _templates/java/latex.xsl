﻿<?xml version="1.0" encoding="UTF-8"?>
<!-- =========================================================== -->
<!--           Script de conversion de eLML vers LaTeX           -->
<!-- =========================================================== -->
<!-- 1) On importe le script global fournit par ELML             -->
<!-- 2) On défnit les paramètres de conversion                   -->
<!--    (auront la priorité sur les valeurs globales)            -->
<!-- 3) On recopie et modifie les parties qui ne conviennent pas -->   
<!-- =========================================================== -->
<xsl:stylesheet xmlns:elml="http://www.elml.ch" version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2004/07/xpath-functions" xmlns:xdt="http://www.w3.org/2004/07/xpath-datatypes" xmlns:fox="http://xml.apache.org/fop/extensions">
	<!-- Importation de la transformation par défaut-->
	<xsl:import href="../../../core/presentation/latex/elml.xsl"/>
	<!-- Définition des paramètres  -->
	<!-- The name of this layout (=folder name of template folder!) -->
	<xsl:param name="layout" select="'java'"/>
	<xsl:param name="documentclass" select="'article'"/>
	<xsl:param name="pagebreak_level" select="'lesson'"/>
	<xsl:param name="chapter_numeration" select="'yes'"/>
	<xsl:param name="display_links" select="'yes'"/>
	
	    <xsl:character-map name="latex">
        <!-- Quote for ZapfDingbats character -->
        <xsl:output-character character="&#xE004;" string="&quot;"/>
        <!--
        <xsl:output-character character="&lt;" string="\ensuremath{&lt;}"/>
        <xsl:output-character character="&gt;" string="\ensuremath{&gt;}"/>
        <xsl:output-character character="&quot;" string="''"/>
        -->
        <!-- ASCII characters -->
        <xsl:output-character character="’" string="'"/>
        <xsl:output-character character="‘" string="'"/>
        <xsl:output-character character="$" string="\$"/>
        <xsl:output-character character="#" string="\#"/>
        <xsl:output-character character="%" string="\%"/>
        <xsl:output-character character="~" string="\char`\~"/>
        <xsl:output-character character="&amp;" string="\&amp;"/>
        <xsl:output-character character="^" string="\char`\^"/>
        <xsl:output-character character="„" string="\glqq "/>
        <xsl:output-character character="“" string="\grqq "/>
        <xsl:output-character character="…" string="..."/>
        <!-- Latin 1 Chars -->
        <xsl:output-character character="—" string="-"/>
        <xsl:output-character character="–" string="-"/>
        <xsl:output-character character="¡" string="\textexclamdown "/>
        <xsl:output-character character="¢" string="\textcent "/>
        <xsl:output-character character="£" string="\textsterling "/>
        <xsl:output-character character="¤" string="\textcurrency "/>
        <xsl:output-character character="¥" string="\textyen "/>
        <xsl:output-character character="¦" string="\textbrokenbar "/>
        <xsl:output-character character="§" string="\textsection "/>
        <xsl:output-character character="¨" string="\textasciidieresis "/>
        <xsl:output-character character="©" string="\copyright "/>
        <xsl:output-character character="ª" string="\textordfeminine "/>
        <xsl:output-character character="«" string="\guillemotleft "/>
        <xsl:output-character character="¬" string="\textlnot "/>
        <xsl:output-character character="®" string="\textregistered "/>
        <xsl:output-character character="¯" string="\textasciimacron "/>
        <xsl:output-character character="°" string="\textdegree "/>
        <xsl:output-character character="±" string="\textpm "/>
        <xsl:output-character character="²" string="\texttwosuperior "/>
        <xsl:output-character character="³" string="\textthreesuperior "/>
        <xsl:output-character character="´" string="\textasciiacute "/>
        <xsl:output-character character="µ" string="\textmu "/>
        <xsl:output-character character="¶" string="\textparagraph "/>
        <xsl:output-character character="·" string="\textbullet "/>
        <xsl:output-character character="¹" string="\textonesuperior "/>
        <xsl:output-character character="º" string="\textordmasculine "/>
        <xsl:output-character character="»" string="\guillemotright "/>
        <xsl:output-character character="¼" string="\textonequarter "/>
        <xsl:output-character character="½" string="\textonehalf "/>
        <xsl:output-character character="¾" string="\textthreequarters "/>
        <xsl:output-character character="¿" string="\textquestiondown "/>
        <xsl:output-character character="À" string="\`A"/>
        <xsl:output-character character="Á" string="\'A"/>
        <xsl:output-character character="Â" string="\^A"/>
        <xsl:output-character character="Ã" string="\~A"/>
        <xsl:output-character character="Ä" string="\&quot;A"/>
        <xsl:output-character character="Å" string="\AA"/>
        <xsl:output-character character="Æ" string="\AE"/>
        <xsl:output-character character="Ç" string="\c C"/>
        <xsl:output-character character="È" string="\`E"/>
        <xsl:output-character character="É" string="\'E"/>
        <xsl:output-character character="Ê" string="\^E"/>
        <xsl:output-character character="Ë" string="\&quot;E"/>
        <xsl:output-character character="Ì" string="\`I"/>
        <xsl:output-character character="Í" string="\'I"/>
        <xsl:output-character character="Î" string="\^I"/>
        <xsl:output-character character="Ï" string="\&quot;I"/>
        <xsl:output-character character="Ñ" string="\~N"/>
        <xsl:output-character character="Ò" string="\`O"/>
        <xsl:output-character character="Ó" string="\'O"/>
        <xsl:output-character character="Ô" string="\^O"/>
        <xsl:output-character character="Õ" string="\~O"/>
        <xsl:output-character character="Ö" string="\&quot;O"/>
        <xsl:output-character character="×" string="\texttimes "/>
        <xsl:output-character character="Ø" string="\O"/>
        <xsl:output-character character="Ù" string="\`U"/>
        <xsl:output-character character="Ú" string="\'U"/>
        <xsl:output-character character="Û" string="\^U"/>
        <xsl:output-character character="Ü" string="\&quot;U"/>
        <xsl:output-character character="Ý" string="\'Y"/>
        <xsl:output-character character="ß" string="\ss "/>
        <xsl:output-character character="à" string="\`a"/>
        <xsl:output-character character="á" string="\'a"/>
        <xsl:output-character character="â" string="\^a"/>
        <xsl:output-character character="ã" string="\~a"/>
        <xsl:output-character character="ä" string="\&quot;a"/>
        <xsl:output-character character="å" string="\aa"/>
        <xsl:output-character character="æ" string="\ae"/>
        <xsl:output-character character="ç" string="\c c"/>
        <xsl:output-character character="è" string="\`e"/>
        <xsl:output-character character="é" string="\'e"/>
        <xsl:output-character character="ê" string="\^e"/>
        <xsl:output-character character="ë" string="\&quot;e"/>
        <xsl:output-character character="ì" string="\`i"/>
        <xsl:output-character character="í" string="\'i"/>
        <xsl:output-character character="î" string="\^i"/>
        <xsl:output-character character="ï" string="\&quot;i"/>
        <xsl:output-character character="ñ" string="\~n"/>
        <xsl:output-character character="ò" string="\`o"/>
        <xsl:output-character character="ó" string="\'o"/>
        <xsl:output-character character="ô" string="\^o"/>
        <xsl:output-character character="õ" string="\~o"/>
        <xsl:output-character character="ö" string="\&quot;o"/>
        <xsl:output-character character="÷" string="\textdiv"/>
        <xsl:output-character character="ø" string="\o"/>
        <xsl:output-character character="ù" string="\`u"/>
        <xsl:output-character character="ú" string="\'u"/>
        <xsl:output-character character="û" string="\^u"/>
        <xsl:output-character character="ü" string="\&quot;u"/>
        <xsl:output-character character="ý" string="\'y"/>
        <xsl:output-character character="ÿ" string="\&quot;y"/>
        <xsl:output-character character="•" string="\textbullet "/>
        <xsl:output-character character="_" string="\_"/>
        <xsl:output-character character="&#0160;" string=" "/>
        <xsl:output-character character="→" string="\rightarrow"/>
        <!-- Greek Characters -->
        <xsl:output-character character="α" string="\alpha"/>
        <xsl:output-character character="θ" string="\theta"/>
        <xsl:output-character character="τ" string="\tau"/>
        <xsl:output-character character="β" string="\beta"/>
        <xsl:output-character character="ϑ" string="\vartheta"/>
        <xsl:output-character character="π" string="\pi"/>
        <xsl:output-character character="υ" string="\upsilon"/>
        <xsl:output-character character="γ" string="\gamma"/>
        <xsl:output-character character="ι" string="\iota"/>
        <xsl:output-character character="ϖ" string="\varpi"/>
        <xsl:output-character character="φ" string="\phi"/>
        <xsl:output-character character="δ" string="\delta"/>
        <xsl:output-character character="κ" string="\kappa"/>
        <xsl:output-character character="ρ" string="\rho"/>
        <xsl:output-character character="ϕ" string="\varphi"/>
        <xsl:output-character character="ϵ" string="\epsilon"/>
        <xsl:output-character character="λ" string="\lambda"/>
        <xsl:output-character character="ϱ" string="\varrho"/>
        <xsl:output-character character="χ" string="\chi"/>
        <xsl:output-character character="ε" string="\varepsilon"/>
        <xsl:output-character character="µ" string="\mu"/>
        <xsl:output-character character="σ" string="\sigma"/>
        <xsl:output-character character="ψ" string="\psi"/>
        <xsl:output-character character="ζ" string="\zeta"/>
        <xsl:output-character character="ν" string="\nu"/>
        <xsl:output-character character="ς" string="\varsigma"/>
        <xsl:output-character character="ω" string="\omega"/>
        <xsl:output-character character="η" string="\eta"/>
        <xsl:output-character character="ξ" string="\xi"/>
        <xsl:output-character character="Γ" string="\Gamma"/>
        <xsl:output-character character="Λ" string="\Lambda"/>
        <xsl:output-character character="Σ" string="\Sigma"/>
        <xsl:output-character character="Ψ" string="\Psi"/>
        <xsl:output-character character="∆" string="\Delta"/>
        <xsl:output-character character="Ξ" string="\Xi"/>
        <xsl:output-character character="Υ" string="\Upsilon"/>
        <xsl:output-character character="Ω" string="\Omega"/>
        <xsl:output-character character="Θ" string="\Theta"/>
        <xsl:output-character character="Π" string="\Pi"/>
        <xsl:output-character character="Φ" string="\Phi"/>
        <xsl:output-character character="ο" string="o"/>
        <!-- Problemfälle:
            
            <xsl:output-character character="_" string="\_"/>
            <xsl:output-character character="\" string="\textbackslash"/>
            <xsl:output-character character="{" string="\{"/>
            <xsl:output-character character="}" string="\}"/>
        -->
    </xsl:character-map>
    
	<!-- ===== / ===== -->
	<!-- Ajout du package pifonts pour la police dingbats utilisée pour les cases à cocher des QCM -->
	<!-- Mise en forme de la premièer page : on utilise le plus possible le tag metadata -->
	    <xsl:template match="/">
        <xsl:result-document href="{$pathRoot}/{/elml:lesson/@label}/{$lang}/latex/{/elml:lesson/@label}{$filename_suffix}" format="latex">
            <xsl:text>\documentclass[11pt,a4paper]{</xsl:text>
            <xsl:value-of select="$documentclass"/>
            <xsl:text>}
			</xsl:text>
            <xsl:choose>
                <xsl:when test="$lang='de'">
                    <xsl:text>\usepackage{ngerman}
					</xsl:text>
                </xsl:when>
                <xsl:when test="$lang='fr'">
                    <xsl:text>\usepackage[french]{babel}
					</xsl:text>
                </xsl:when>
                <xsl:when test="$lang='it'">
                    <xsl:text>\usepackage[italian]{babel}
					</xsl:text>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:text>\usepackage[english]{babel}
					</xsl:text>
                </xsl:otherwise>
            </xsl:choose>
            <xsl:if test="not($chapter_numeration='yes')">
                <xsl:text>\setcounter{secnumdepth}{-1}
				</xsl:text>
            </xsl:if>
            <xsl:text disable-output-escaping="yes">
				\usepackage{pifont}  <!-- MCD: Pour dingbats -->
				\usepackage[utf8x]{inputenc}
				\usepackage[T1]{fontenc} 
				\usepackage{lmodern}			
				\usepackage{fancyhdr}
				\usepackage{textcomp}
				\usepackage{makeidx}
				\usepackage{tabularx}
				\usepackage{multicol}
				\usepackage{multirow}
				\usepackage{longtable}
				\usepackage{color}
				\usepackage{soul}
				\usepackage{boxedminipage}
				\usepackage{shadow}
				\usepackage{framed}			
				\usepackage{array}
				\usepackage{url}
				\usepackage{ragged2e}
				\usepackage{fancybox}
				\newcommand{\cadretitre}[2]{
				  \vspace*{0.8\baselineskip}
				  \begin{center}%
				  \boxput*(0,1){%
					%\colorbox{white}{\Large\textbf{\ #1\ }}%
				  }%
				  {%
					\setlength{\fboxsep}{10pt}%
				    \Ovalbox{\begin{minipage}{.8\linewidth}\begin{center}\Large\sffamily{#2}\end{center}\end{minipage}}}%
				  \end{center}
				  \vspace*{2\baselineskip}
				  }
			
			\makeatletter
			\def\@seccntformat#1{\protect\makebox[0pt][r]{\csname the#1\endcsname\quad}}
			\makeatother

				% Permet d'afficher qqchose à une positin absolue
				\usepackage[absolute]{textpos}
				\setlength{\TPHorizModule}{1cm}
				\setlength{\TPVertModule}{\TPHorizModule}
	
				\usepackage[titles]{tocloft}
				\setlength{\cftbeforesecskip}{0.5ex}
				\setlength{\cftbeforesubsecskip}{0.2ex}
				\addto\captionsfrench{\renewcommand\contentsname{}}
				
				\usepackage[font=scriptsize]{caption}
				
				\usepackage{listings}
\lstdefinestyle{lstverb}
  {
    basicstyle=\footnotesize,
    frameround=tttt, frame=trbl, framerule=0pt, rulecolor=\color{gray},
    lineskip=-1pt,   % pour rapprocher les lignes
    flexiblecolumns, escapechar=\\,
    tabsize=4, extendedchars=true
  }
\lstnewenvironment{Java}[1][]{\lstset{style=lstverb,language=java,#1}}{}
				\ifx\pdfoutput\undefined
					\usepackage{graphicx}
				\else
					\usepackage[pdftex]{graphicx}
				\fi
				\usepackage[a4paper, hyperfigures=true, colorlinks, linkcolor=black, citecolor=blue,urlcolor=blue, pagebackref=true, bookmarks=true, bookmarksopen=true,bookmarksnumbered=true,
                pdfauthor={</xsl:text>
            <xsl:choose>
                <xsl:when test="$multiple='on' and document($config_file)/elml:config/elml:modules/elml:course[child::node()=$transformlesson_label]/@authors">
                    <xsl:value-of select="document($config_file)/elml:config/elml:modules/elml:course[child::node()=$transformlesson_label]/@authors" disable-output-escaping="yes"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:for-each select="/elml:lesson/elml:metadata/elml:lessonInfo/elml:lifecycle/elml:contribute/elml:person">
                        <xsl:value-of select="@name" disable-output-escaping="yes"/>
                        <xsl:if test="not(position()=last())">
                            <xsl:text>, </xsl:text>
                        </xsl:if>
                    </xsl:for-each>
                </xsl:otherwise>
            </xsl:choose>
            <xsl:text>}, pdftitle={</xsl:text>
            <xsl:choose>
                <xsl:when test="$multiple='on' and document($config_file)/elml:config/elml:modules/elml:course[child::node()=$transformlesson_label]/@title">
                    <xsl:value-of select="document($config_file)/elml:config/elml:modules/elml:course[child::node()=$transformlesson_label]/@title"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="/elml:lesson/@title" disable-output-escaping="yes"/>
                </xsl:otherwise>
            </xsl:choose>
            <xsl:text>}, pdfkeywords={</xsl:text>
            <xsl:value-of select="/elml:lesson/@title"/>, <xsl:for-each select="/elml:lesson/elml:metadata/elml:keywords/elml:keywordItem">
                <xsl:value-of select="." disable-output-escaping="yes"/>
                <xsl:if test="not(position()=last())">, </xsl:if>
            </xsl:for-each>
            <xsl:for-each select="/elml:lesson/elml:glossary/elml:definition">
                <xsl:value-of select="@term" disable-output-escaping="yes"/>, </xsl:for-each>
            <xsl:text disable-output-escaping="yes">},pdfpagemode=UseOutlines,pdfpagetransition=Dissolve,nesting=true,
				backref, pdffitwindow=true, bookmarksnumbered=true]{hyperref}
				\usepackage{supertabular}
				\usepackage[table]{xcolor}
				\usepackage{url}
				\usepackage{caption} 
				\setlength{\parskip}{1.3ex plus 0.2ex minus 0.2ex}
				\setlength{\parindent}{0pt}
				
				\makeatletter
				\def\url@leostyle{ \@ifundefined{selectfont}{\def\UrlFont{\sf}}{\def\UrlFont{\footnotesize\ttfamily}}}
				\makeatother
				\urlstyle{leo}
				
				\definecolor{examplecolor}{rgb}{0.156,0.333,0.443}
				\definecolor{definitioncolor}{rgb}{0.709,0.784,0.454}
				\definecolor{exercisecolor}{rgb}{0.49,0.639,0}
				\definecolor{hintcolor}{rgb}{0.941,0.674,0.196}
				\definecolor{tableHeadercolor}{rgb}{0.709,0.784,0.454}
				\definecolor{tablerowAltcolor}{rgb}{.866,.905,.737}
				\definecolor{tablerowAlt2color}{rgb}{.968,.976,.933}
				\definecolor{verylightgray}{rgb}{0.98,0.98,0.98}
				
				\newenvironment{fshaded}{
				\def\FrameCommand{\fcolorbox{framecolor}{shadecolor}}
				\MakeFramed {\FrameRestore}}
				{\endMakeFramed}
				
				\newenvironment{fexample}[1][]{\definecolor{shadecolor}{rgb}{.913,.913,.913}
				\definecolor{framecolor}{rgb}{.156,.333,.443}
				\begin{fshaded}}{\end{fshaded}} 
				
				\newenvironment{fdefinition}{\definecolor{shadecolor}{rgb}{.913,.913,.913}
				\definecolor{framecolor}{rgb}{.709,.784,.454}
				\begin{fshaded}}{\end{fshaded}}
				
				\newenvironment{fexercise}{\definecolor{shadecolor}{rgb}{.913,.913,.913}
				\definecolor{framecolor}{rgb}{.49,.639,0}
				\begin{fshaded}}{\end{fshaded}}
				
				\newenvironment{fhint}{\definecolor{shadecolor}{rgb}{.913,.913,.913}
				\definecolor{framecolor}{rgb}{.941,.674,.196}
				\begin{fshaded}}{\end{fshaded}}	
				
				\newcommand{\PreserveBackslash}[1]{
				\let\temp=\\#1\let\\=\temp
				}
				\let\PBS=\PreserveBackslash
				\newcolumntype{A}{>{\PBS\raggedright\small\hspace{0pt}}X}
				\newcolumntype{L}[1]{>{\PBS\raggedright\small\hspace{0pt}}p{#1}}
				\newcolumntype{R}[1]{>{\PBS\raggedleft\small\hspace{0pt}}p{#1}}
				\newcolumntype{C}[1]{>{\PBS\centering\small\hspace{0pt}}p{#1}}
				
				\makeindex
				
				\title{</xsl:text>
            <xsl:choose>
                <xsl:when test="$multiple='on' and document($config_file)/elml:config/elml:modules/elml:course[child::node()=$transformlesson_label]/@title">
                    <xsl:value-of select="document($config_file)/elml:config/elml:modules/elml:course[child::node()=$transformlesson_label]/@title"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="/elml:lesson/@title"/>
                </xsl:otherwise>
            </xsl:choose>
            <xsl:text>}	
			\date{}
			\author{\scriptsize{</xsl:text>
			<xsl:for-each select="/elml:lesson/elml:metadata/elml:lessonInfo/elml:lifecycle/elml:contribute/elml:person">
				<xsl:value-of select="@name" disable-output-escaping="yes"/>
				<xsl:if test="not(position()=last())">
					<xsl:text>, </xsl:text>
				</xsl:if>
			</xsl:for-each>
			<xsl:text>}}
			\definecolor{light-gray}{gray}{0.8}
			\renewcommand{\headrulewidth}{0pt}
			\fancyhead[L]{
				\footnotesize\textsc{Haute École de Bruxelles}\\
	    			\footnotesize\textsc{École Supérieure d'Informatique}
			}
			\fancyhead[R]{
				\footnotesize{Bachelor en Informatique}\\
				\footnotesize{Laboratoires Java} - 
			\footnotesize{1ère année}}
				\fancyfoot[L]{ </xsl:text>
		<xsl:text disable-output-escaping="yes">}
				\fancyfoot[C]{}
				\fancyfoot[R]{\scriptsize{\textcolor{gray}{version 2014-2015 (\today)}}}
				\pagestyle{plain}
				\reversemarginpar
				\usepackage{rotating}						
				\begin{document}
					\begin{textblock}{9}(2,3.2)
						\includegraphics[width=2cm]{../../../_templates/java/icons/logo-esi}
					\end{textblock}
				<!--\setcounter{section}{-1}-->
				<!--\addtocounter{section}{</xsl:text>-->
				<!--<xsl:value-of select="/elml:lesson/elml:metadata/elml:organisation/elml:creationPosition/elml:posNumber"/>-->
				<!--<xsl:text>}-->
				%\maketitle
				\cadretitre{TD1}{</xsl:text><xsl:value-of select="/elml:lesson/@title"/><xsl:text disable-output-escaping="yes">}
				\thispagestyle{fancy}
        \marginpar{\begin{sideways}
            \begin{minipage}[t]{1cm}
            \begin{tiny}
            \includegraphics[width=1\linewidth,height=1\textheight,keepaspectratio=true]{../../../_templates/java/icons/cc-gris.jpg}
			\end{tiny}
			\end{minipage}
            \begin{minipage}[b]{19cm}
            \begin{tiny}
            \textcolor{gray}{Distribué sous licence Creative Commons Paternité - Partage à l'Identique 2.0 Belgique 
            (\texttt{http://creativecommons.org/licenses/by-sa/2.0/be/})
			\vspace{-1em}
			\\Les autorisations au-delà du champ de cette licence peuvent être obtenues à 
			\texttt{</xsl:text><xsl:value-of select="$server"/><xsl:text>}
			- \texttt{</xsl:text><xsl:value-of select="$contact"/><xsl:text>}
			}\end{tiny}
			\end{minipage}
        \end{sideways}}
            </xsl:text>
				<xsl:apply-templates select="./elml:lesson/elml:entry"/>
				<xsl:text>
				\vspace{-2em}\tableofcontents
				\pagestyle{plain}
            \clearpage
            \fancyhead[L,C,R]{}
            \fancyfoot[L,C]{}
            \fancyfoot[R]{ \scriptsize{\textcolor{gray}{
				</xsl:text><xsl:value-of select="/elml:lesson/@label"/><xsl:text> - page \thepage}}}
				\thispagestyle{fancy}
				\pagestyle{fancy}
	   
            </xsl:text>
            <xsl:choose>
                <xsl:when test="$multiple='on'">
                    <xsl:for-each select="document($config_file)/elml:config/elml:modules/elml:course[child::node()=$transformlesson_label]/elml:labelname">
                        <xsl:apply-templates select="document(concat(substring-before($config_file,'_config'),text(),'/',$lang,'/text/',text(),'.xml'))/elml:lesson"/>
                    </xsl:for-each>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:apply-templates select=".//elml:unit"/>
                </xsl:otherwise>
            </xsl:choose>
            <xsl:apply-templates select="/elml:lesson/elml:bibliography" mode="multiple"/>
            <xsl:call-template name="elml:index"/>
            <xsl:if test="/elml:lesson/elml:listOfFigures[not(@visible='online') and not(@visible='none')] and (not(count(//elml:multimedia) = 0) or $multiple='on')">
                <xsl:if test="$pagebreak_level='unit' or $pagebreak_level='lo'">
                    <xsl:text>
                        \clearpage
                    </xsl:text>
                </xsl:if>
                <xsl:text>
                    \listoffigures
                    \addcontentsline{toc}{</xsl:text>
                <xsl:choose>
                    <xsl:when test="$documentclass='book'">
                        <xsl:text>chapter</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>section</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:text>}{</xsl:text>
                <xsl:value-of select="$name_figures"/>
                <xsl:text>}
                </xsl:text>
            </xsl:if>
            <xsl:if test="/elml:lesson/elml:listOfTables[not(@visible='online') and not(@visible='none')] and (not(count(//elml:table) = 0) or $multiple='on')">
                <xsl:if test="$pagebreak_level='unit' or $pagebreak_level='lo'">
                    <xsl:text>
                        \clearpage
                    </xsl:text>
                </xsl:if>
                <xsl:text>
                    \listoftables
                    \addcontentsline{toc}{</xsl:text>
                <xsl:choose>
                    <xsl:when test="$documentclass='book'">
                        <xsl:text>chapter</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:text>section</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:text>}{</xsl:text>
                <xsl:value-of select="$name_tables"/>
                <xsl:text>}
                </xsl:text>
            </xsl:if>
            <xsl:text>
				\end{document}
			</xsl:text>
        </xsl:result-document>
    </xsl:template>

    <xsl:template match="elml:popup">
	    <xsl:param name="display">
            <xsl:call-template name="elml:display"/>
        </xsl:param>
        <xsl:if test="@cadre='yes'">
			<xsl:text>\fcolorbox{gray}{verylightgray}{\parbox{\textwidth}{\textcolor{verylightgray}{\LARGE </xsl:text>
			<xsl:value-of select="." disable-output-escaping="yes"/>
			<xsl:text>}}}</xsl:text>
		</xsl:if>
        <xsl:if test="$display='yes'">
			<xsl:text> {\footnotesize\emph{(</xsl:text>
			<xsl:if test="@title">
				<xsl:value-of select="@title"/> 
			</xsl:if>
			<xsl:if test="@title=''">un complément d'information</xsl:if> 
			<xsl:text> est disponible dans la version en ligne)}\par} </xsl:text>
	    </xsl:if>
    </xsl:template>

	 <!-- Suppression des espaces autour des textes formattés -->
    <xsl:template match="elml:formatted[@style='bold']">
        <xsl:text>\textbf{</xsl:text><xsl:apply-templates/><xsl:text>}</xsl:text>
    </xsl:template>

    <xsl:template match="elml:formatted[@style='superscript']">
		<xsl:text>\textsuperscript{</xsl:text><xsl:value-of select="."/><xsl:text>}</xsl:text>
    </xsl:template>

    <xsl:template match="elml:formatted[@style='italic']">
        <xsl:text>\textit{</xsl:text><xsl:apply-templates/><xsl:text>}</xsl:text>
    </xsl:template>

    <xsl:template match="elml:formatted[@style='input']">
        <xsl:text>\,\verb|</xsl:text><xsl:value-of select="." disable-output-escaping="yes"/><xsl:text>|\,</xsl:text>
    </xsl:template>

    <xsl:template match="elml:formatted[@style='code']">
        <xsl:text>\verb@</xsl:text><xsl:value-of select="." disable-output-escaping="yes"/><xsl:text>@</xsl:text>
    </xsl:template>

   <xsl:template match="elml:formatted[@style='LatexNewline']">
        <xsl:text>\\</xsl:text>
    </xsl:template>

    <xsl:template match="elml:formatted[@style='java']">
        <xsl:text>\verb|</xsl:text><xsl:value-of select="." disable-output-escaping="yes"/><xsl:text>|</xsl:text>
    </xsl:template>

    <xsl:template match="elml:paragraph[@cssClass='code']">
        <xsl:param name="display">
            <xsl:call-template name="elml:display"/>
        </xsl:param>
        <xsl:if test="$display='yes'">
        <xsl:text>\begin{verbatim}</xsl:text><xsl:value-of select="." disable-output-escaping="yes"/><xsl:text>\end{verbatim}</xsl:text>
		</xsl:if>
    </xsl:template>

    <xsl:template match="elml:paragraph[@cssClass='output']">
        <xsl:param name="display">
            <xsl:call-template name="elml:display"/>
        </xsl:param>
        <xsl:if test="$display='yes'">
        <xsl:text>\begin{scriptsize}\begin{verbatim}</xsl:text><xsl:value-of select="." disable-output-escaping="yes"/><xsl:text>\end{verbatim}\end{scriptsize}</xsl:text>
		</xsl:if>
    </xsl:template>

    <xsl:template match="elml:paragraph[@cssClass='java']">
        <xsl:param name="display">
            <xsl:call-template name="elml:display"/>
        </xsl:param>
        <xsl:if test="$display='yes'">
        <xsl:text>\begin{Java}</xsl:text><xsl:value-of select="." disable-output-escaping="yes"/><xsl:text>\end{Java}</xsl:text>
		</xsl:if>
    </xsl:template>

    <xsl:template match="elml:paragraph[@cssClass='javawithblanks']">
        <xsl:param name="display">
            <xsl:call-template name="elml:display"/>
        </xsl:param>
        <xsl:if test="$display='yes'">
			<xsl:text>\begin{Java}</xsl:text><xsl:apply-templates/><xsl:text>\end{Java}</xsl:text>
		</xsl:if>
    </xsl:template>

    <xsl:template match="elml:question">
        <xsl:apply-templates/>
    </xsl:template>

<!-- Pas de newLine dans une <question> -->    
    <xsl:template match="//elml:question//elml:newLine"/>

    <!-- Test pour enlever le niveau d'indentation supérieure -->
    <xsl:template match="elml:lesson">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="elml:unit">
		<xsl:text>\section{</xsl:text><xsl:value-of select="@title"/><xsl:text>}</xsl:text> 
		<xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="elml:learningObject">
		<xsl:text>\subsection{</xsl:text><xsl:value-of select="@title"/><xsl:text>}</xsl:text>
		<xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="elml:entry">
		<xsl:if test="name(parent::*)='lesson'">
			<xsl:text>\begin{abstract}</xsl:text>
		</xsl:if>
		<xsl:apply-templates/>
		<xsl:if test="name(parent::*)='lesson'">
			<xsl:text>\end{abstract}</xsl:text>
		</xsl:if>
    </xsl:template>

	 <!-- Citation -->
    <xsl:template match="elml:paragraph[@cssClass='citation']">
        <xsl:text>\begin{quotation}</xsl:text><xsl:apply-templates/><xsl:text>\end{quotation}</xsl:text>
    </xsl:template>
    
    <!-- Texte à trous avec taille fonction de la longueur de la bonne réponse -->
	<xsl:template match="elml:gap">
	<xsl:choose>
		<xsl:when test="$role='tutor'">
			 <xsl:text> \textit{</xsl:text>
			 <xsl:apply-templates/>
			 <xsl:text>}</xsl:text>
		</xsl:when>
		<xsl:otherwise>
			<xsl:choose>
				 <xsl:when test="string-length(.)&lt;2"><xsl:text> \textcolor{gray}{\underline{\hspace*{1em}}} </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;4"><xsl:text> \textcolor{gray}{\underline{\hspace*{2em}}} </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;6"><xsl:text> \textcolor{gray}{\underline{\hspace*{3em}}} </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;8"><xsl:text> \textcolor{gray}{\underline{\hspace*{5em}}} </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;16"><xsl:text> \textcolor{gray}{\underline{\hspace*{10em}}} </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;32"><xsl:text> \textcolor{gray}{\underline{\hspace*{16em}}} </xsl:text></xsl:when>
				 <xsl:otherwise><xsl:text> \textcolor{gray}{\underline{\hspace*{20em}}} </xsl:text></xsl:otherwise>
			</xsl:choose>
		</xsl:otherwise>
	</xsl:choose>
	</xsl:template>

    <!-- Texte à trous avec taille fonction de la longueur de la bonne réponse. Dans Java -->
	<xsl:template match="//elml:paragraph[@cssClass='javawithblanks']//elml:gap">
	<xsl:choose>
		<xsl:when test="$role='tutor'">
			 <xsl:text> \textit{</xsl:text>
			 <xsl:apply-templates/>
			 <xsl:text>}</xsl:text>
		</xsl:when>
		<xsl:otherwise>
			<xsl:choose>
				 <xsl:when test="string-length(.)&lt;2"><xsl:text> \_\_ </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;4"><xsl:text> \_\_\_\_ </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;8"><xsl:text> \_\_\_\_\_\_\_\_ </xsl:text></xsl:when>
				 <xsl:when test="string-length(.)&lt;16"><xsl:text> \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ </xsl:text></xsl:when>
				 <xsl:otherwise><xsl:text> \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_ </xsl:text></xsl:otherwise>
			</xsl:choose>
		</xsl:otherwise>
	</xsl:choose>
	</xsl:template>

	<!-- tentative de gestion des accents dans les URLs -->
    <xsl:template match="elml:link">
        <xsl:param name="label" select="@targetLabel"/>
        <xsl:param name="TempURL">
            <xsl:choose>
                <xsl:when test="not((@role='student') or (@role=$role) or (not (@role)))">
                    <xsl:text>none</xsl:text>
                </xsl:when>
                <xsl:when test="starts-with(@uri, 'http') or starts-with(@uri, 'mailto:')">
                    <xsl:value-of select="@uri"/>
                </xsl:when>
                <xsl:when test="@uri">
                    <xsl:value-of select="$server"/>
                    <xsl:text>/</xsl:text>
                    <xsl:value-of select="/elml:lesson/@label"/>
                    <xsl:text>/</xsl:text>
                    <xsl:value-of select="$lang"/>
                    <xsl:choose>
                        <xsl:when test="starts-with(@uri, '..')">
                            <xsl:value-of select="substring-after(@uri, '..')"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text>/text/</xsl:text>
                            <xsl:value-of select="@uri"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:choose>
                        <xsl:when test="@targetLesson and not(@targetLesson = /elml:lesson/@label)">
                            <xsl:value-of select="$server"/>
                            <xsl:text>/</xsl:text>
                            <xsl:value-of select="@targetLesson"/>
                            <xsl:text>/</xsl:text>
                            <xsl:value-of select="$lang"/>
                            <xsl:text>/</xsl:text>
                        </xsl:when>
                        <xsl:when test="name(//*[@label=$label])='unit'">
                            <xsl:value-of select="/elml:lesson/@label"/>
                            <xsl:text>unit</xsl:text>
                            <xsl:value-of select="@targetLabel"/>
                            <xsl:value-of select="$filename_suffix"/>
                        </xsl:when>
                        <xsl:when test="name(//*[@label=$label])='learningObject'">
                            <xsl:value-of select="/elml:lesson/@label"/>
                            <xsl:value-of select="//*[@label=$label]/../@label"/>
                            <xsl:value-of select="@targetLabel"/>
                            <xsl:value-of select="$filename_suffix"/>
                        </xsl:when>
                        <xsl:when test="@targetLabel">
                            <xsl:value-of select="/elml:lesson/@label"/>
                            <xsl:value-of select="//*[@label=$label]/../@label"/>
                            <xsl:value-of select="@targetLabel"/>
                            <xsl:value-of select="$filename_suffix"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="/elml:lesson/@label"/>
                            <xsl:text>index</xsl:text>
                            <xsl:value-of select="$filename_suffix"/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:param>
        <xsl:choose>
            <xsl:when test="((boolean(name(preceding-sibling::node()[1])) or boolean(name(following-sibling::node()[1]))) and not(../text())) or (count(../*)=number('1') and (name(parent::node())='look' or name(parent::node())='act' or name(parent::node())='clarify'))">
                <xsl:text>
					\par
				</xsl:text>
                <xsl:choose>
                    <xsl:when test="not((@role='student') or (@role=$role) or (not (@role))) or $display_links='no'">
                        <xsl:apply-templates/>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:choose>
                            <xsl:when test="starts-with($TempURL, 'http') or starts-with($TempURL, 'mailto:')">
                                <xsl:apply-templates/>
                                <xsl:text>: \url{</xsl:text>
                                <xsl:value-of select="replace($TempURL,'http://','')" disable-output-escaping="yes"/>
                                <xsl:text>} </xsl:text>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:apply-templates/>
                                <xsl:text>: </xsl:text>
                                <xsl:value-of select="$name_page"/>
                                <xsl:text disable-output-escaping="yes">~</xsl:text>
                                <xsl:text>\pageref{</xsl:text>
                                <xsl:value-of select="replace($TempURL, '_','')" disable-output-escaping="yes"/>
                                <xsl:text>}. </xsl:text>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:if test="@size or @type or @legend">
                    <xsl:text> (</xsl:text>
                    <xsl:if test="@legend">
                        <xsl:value-of select="@legend"/>
                    </xsl:if>
                    <xsl:if test="@size or @type">
                        <xsl:text>, </xsl:text>
                    </xsl:if>
                    <xsl:if test="@size">
                        <xsl:value-of select="$name_size"/>
                        <xsl:text disable-output-escaping="yes">:~</xsl:text>
                        <xsl:value-of select="@size"/>
                        <xsl:if test="@type">
                            <xsl:text>, </xsl:text>
                        </xsl:if>
                    </xsl:if>
                    <xsl:if test="@type">
                        <xsl:value-of select="$name_type"/>
                        <xsl:text>: </xsl:text>
                        <xsl:value-of select="@type"/>
                    </xsl:if>
                    <xsl:text>)</xsl:text>
                </xsl:if>
                <xsl:text>
					\par
				</xsl:text>
            </xsl:when>
            <xsl:when test="not((@role='student') or (@role=$role) or (not (@role))) or $display_links='no'">
                <xsl:apply-templates/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:choose>
                    <xsl:when test="starts-with($TempURL, 'http') or starts-with($TempURL, 'mailto:')">
                        <xsl:apply-templates/>
                        <xsl:text> (\url{</xsl:text>
                        <xsl:value-of select="replace($TempURL,'http://','')"/>
                        <xsl:text>})</xsl:text>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:apply-templates/>
                        <xsl:text> (</xsl:text>
                        <xsl:value-of select="$name_page"/>
                        <xsl:text disable-output-escaping="yes">~</xsl:text>
                        <xsl:text>\pageref{</xsl:text>
                        <xsl:value-of select="replace($TempURL, '_','')" disable-output-escaping="yes"/>
                        <xsl:text>})</xsl:text>
                    </xsl:otherwise>
                </xsl:choose>
                <xsl:if test="$display_links='yes' and (@size or @type or @legend)">
                    <xsl:text>{\footnotesize </xsl:text>
                    <xsl:text> </xsl:text>
                    <xsl:if test="@legend">
                        <xsl:value-of select="@legend"/>
                        <xsl:text>. </xsl:text>
                    </xsl:if>
                    <xsl:if test="@size">
                        <xsl:value-of select="$name_size"/>
                        <xsl:text disable-output-escaping="yes">:~</xsl:text>
                        <xsl:value-of select="@size"/>
                        <xsl:text>. </xsl:text>
                    </xsl:if>
                    <xsl:if test="@type">
                        <xsl:value-of select="$name_type"/>
                        <xsl:text>: </xsl:text>
                        <xsl:value-of select="@type"/>
                        <xsl:text>. </xsl:text>
                    </xsl:if>
                    <xsl:text>}</xsl:text>
                </xsl:if>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

	<!-- Si une table ne contient ni legend ni title -> pas de caption -->
    <xsl:template match="elml:table" mode="icon">
        <xsl:param name="columnwidth" select="$textwidth div count(./elml:tablerow[1]/child::node())"/>
        <xsl:text>
				\par
                \begin{longtable}{</xsl:text>
        <xsl:for-each select="elml:tablerow[1]/*">
            <xsl:choose>
                <xsl:when test="@colspan">
                    <xsl:call-template name="elml:columncreate">
                        <xsl:with-param name="columnamount" select="@colspan"/>
                        <xsl:with-param name="columnwidth" select="$columnwidth"/>
                    </xsl:call-template>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:call-template name="elml:columncreate">
                        <xsl:with-param name="columnamount" select="1"/>
                        <xsl:with-param name="columnwidth" select="$columnwidth"/>
                    </xsl:call-template>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:for-each>
        <xsl:text>|}</xsl:text>
        <xsl:text>\hline
		\endhead
        </xsl:text>
        <xsl:choose>
            <xsl:when test="@title and @legend">
                <xsl:text>
                    \caption[</xsl:text>
                <xsl:value-of select="@legend"/>
                <xsl:text>]{</xsl:text>
                <xsl:value-of select="@title"/>
                <xsl:text>: </xsl:text>
                <xsl:value-of select="@legend"/>
                <xsl:if test="@bibIDRef">
                    <xsl:text> \protect</xsl:text>
                    <xsl:call-template name="elml:BibliographyRef"/>
                </xsl:if>
                <xsl:text>}
                </xsl:text>
            </xsl:when>
            <xsl:when test="@legend">
                <xsl:text>
                    \caption[</xsl:text>
                <xsl:value-of select="@legend"/>
                <xsl:text>]{</xsl:text>
                <xsl:value-of select="@legend"/>
                <xsl:if test="@bibIDRef">
                    <xsl:text> \protect</xsl:text>
                    <xsl:call-template name="elml:BibliographyRef"/>
                </xsl:if>
                <xsl:text>}
                </xsl:text>
            </xsl:when>
            <xsl:when test="@title">
                <xsl:text>
                    \caption[</xsl:text>
                <xsl:value-of select="@title"/>
                <xsl:text>]{</xsl:text>
                <xsl:value-of select="@title"/>
                <xsl:if test="@bibIDRef">
                    <xsl:text> \protect</xsl:text>
                    <xsl:call-template name="elml:BibliographyRef"/>
                </xsl:if>
                <xsl:text>}
                </xsl:text>
            </xsl:when>
        </xsl:choose>
        <xsl:call-template name="elml:Label"/>
        <xsl:text>
			\endfoot
        </xsl:text>
        <xsl:apply-templates mode="#default"/>
        <xsl:text>
			\end{longtable}
		</xsl:text>
    </xsl:template>

    <!-- Le calcul de la taille ne m'avait pas l'air correct -->
    <xsl:template name="elml:image_width_height">
        <xsl:choose>
            <xsl:when test="@units='percent' and @width">
                <xsl:value-of select="@width div 100"/>
                <xsl:text>\linewidth,</xsl:text>
            </xsl:when>
            <xsl:when test="@width and ((@width * $converter_pixel_mm) &lt; (textwidth * 10))">
                <xsl:value-of select="@width * $converter_pixel_mm"/>
                <xsl:text>mm,</xsl:text>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>0.8\linewidth,</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

	<!-- Imposer un pagebreak -->
    <xsl:template match="elml:paragraph[@cssClass='pagebreak']">
        <xsl:param name="display">
            <xsl:call-template name="elml:display"/>
        </xsl:param>
        <xsl:if test="$display='yes'">
        <xsl:text>\clearpage</xsl:text>
		</xsl:if>
    </xsl:template>

	<!-- Cadre pour réponse libre -->
    <xsl:template match="elml:paragraph[@cssClass='cadre']">
        <xsl:text>
			\fcolorbox{gray}{verylightgray}{
			\begin{minipage}[c][</xsl:text><xsl:value-of select="@lines"/><xsl:text>cm][c]{\textwidth}\textcolor{verylightgray}{X}\end{minipage}
		}\par\medskip</xsl:text>
    </xsl:template>

</xsl:stylesheet>
