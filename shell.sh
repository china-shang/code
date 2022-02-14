#!/bin/bash
# 有效的电话号码,ere bre不支持简写\d. ERE不需要斜杠就能代表特殊含义
grep -E "^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$" file.txt

#显示第十行
sed -n '10p' file.txt
tail +10 file.txt |head -1

#统计词频
cat words.txt | tr -s ' ' '\n' | sort |uniq -c | sort -n -r | awk '{print $2,$1}'

