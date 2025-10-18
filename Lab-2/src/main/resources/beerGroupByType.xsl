<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:key name="byType" match="BeerItem" use="Type"/>

    <xsl:template match="/Beer">
        <GroupedBeer>
            <xsl:for-each select="BeerItem[generate-id() = generate-id(key('byType', Type)[1])]">
                <BeerTypeGroup type="{Type}">
                    <xsl:for-each select="key('byType', Type)">
                        <xsl:copy-of select="."/>
                    </xsl:for-each>
                </BeerTypeGroup>
            </xsl:for-each>
        </GroupedBeer>
    </xsl:template>

</xsl:stylesheet>