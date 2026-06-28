# MMOItemsPAPI

MMOItemsPAPI is a PlaceholderAPI expansion that provides additional placeholders for MMOItems. <br/>
Required plugins：
- MMOItems
- PlaceHolderAPI
- MythicLibs
- MythicMobs (options)

<br/>

## Placeholder
- `%mmoitempapi_heldItem_isMMOITEM%`
- `%mmoitempapi_heldItem_type%`
- `%mmoitempapi_heldItem_id%`
- `%mmoitempapi_heldItem_tier%`
- `%mmoitempapi_heldItem_set%`
- `%mmoitempapi_heldItem_canUse%`

 <br/>
 
## MythicCondition: ```isMMOItem```
check if the player is holding item is from MMOItems.
<br/>
 
### Attributes
- `type` `t` - match specific item type 
- `item` `i` - match MMOItems ID
- `tier` - match specific item tier 
- `usable` `u` - check if player meets all usage requirements (eg.MMOCore Class, Profession)

### Example
```yaml
Conditions:
- isMMOItem true #check if player holding any mmoitem
- isMMOItem{type=SWORD} true #check if player holding any type:SWORD mmoitem
Skills:
- message{m="%mmoitempapi_heldItem_tier%"} @Self
```
 
