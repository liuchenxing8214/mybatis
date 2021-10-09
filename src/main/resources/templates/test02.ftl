<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
<sdQuery>
    <clientID>${clientId}</clientID>
    <clientType>CUSTOMER</clientType>
    <createCaseOnMatches>CREATECASE</createCaseOnMatches>
    <types>
        <type>${benefType}</type>
    </types>
    <#list userList as user>
    <name name = ${user.benefName} />
    <feedSourceSystem system=${user.feedSourceSystem} />
    <ruleId ${user.ruleId} />
    </#list>
</sdQuery>