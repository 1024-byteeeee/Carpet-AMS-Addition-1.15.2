# Carpet-AMS-Addition

一个简易的基于Carpet mod的拓展（ **此版本已停止维护** ）

### 规则/Rules

`noteBlockChunkLoader`: 开启后，当上边沿红石信号激活音符盒时，为该音符盒所在区块添加类型为"note_block"，加载等级为30的加载票，持续时间为300gt（15s）。

`bellBlockChunkLoader`: 开启后，当上边沿红石信号激活钟时，为钟方块所在区块添加类型为"bell_block"，加载等级为30的加载票，持续时间为300gt（15s）。

`pistonBlockChunkLoader`: 开启后，对于一个正上方放有骨块的普通活塞或黏性活塞，当该活塞产生活塞头的推出/拉回事件时，在创建推出/拉回事件的那一游戏刻为**活塞头方块所在区块**添加类型为"piston_block"，加载等级为30的加载票，持续时间为300gt（15s）。注意，黏性活塞的失败收回事件（如尝试拉回超过12个方块时）也可创建加载票。

`breakableObsdian`: 开启后，黑曜石的挖掘硬度将与深板岩相同

`tntDestroysEverything`: 开启后，TNT爆炸时将能摧毁所有不受流体保护的方块且所有方块的爆炸抗性为0。




## Carpet-AMS-Addition 1.16.5/1.17.1/1.18.2/1.19.3 版本：

[Minecraft-AMS/Carpet-AMS-Addition: 一个简易的基于Carpet mod的拓展 (github.com)](https://github.com/Minecraft-AMS/Carpet-AMS-Addition)
