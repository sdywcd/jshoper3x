//
//  MainViewController.m
//  01 HomeWork
//
//  Created by wei.chen on 14-1-8.
//  Copyright (c) 2014年 www.iphonetrain.com 无限互联3G学院. All rights reserved.
//

#import "MainViewController.h"

@interface MainViewController ()

@end

@implementation MainViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    _data = [[UIFont familyNames] retain];
    self.filteData = _data;
    
    UITextField *textField = [[UITextField alloc] initWithFrame:CGRectMake(0, 0, 200, 30)];
    textField.borderStyle = UITextBorderStyleRoundedRect;
    //取消首字母自动大写
    textField.autocapitalizationType = UITextAutocapitalizationTypeNone;
    textField.delegate = self;
    [textField addTarget:self action:@selector(changeAction:)
        forControlEvents:UIControlEventEditingChanged];
    self.navigationItem.titleView = textField;
    [textField release];
    
    
    //添加监听通知：UITextFieldTextDidChangeNotification
//    [[NSNotificationCenter defaultCenter] addObserver:self
//                                             selector:@selector(changeNotification:)
//                                                 name:UITextFieldTextDidChangeNotification object:nil];
    
}

//- (BOOL)textField:(UITextField *)textField shouldChangeCharactersInRange:(NSRange)range replacementString:(NSString *)string {
//    
//    NSString *t = textField.text;
//    NSLog(@"text = %@",t);
//    
//    return YES;
//}

//- (void)changeNotification:(NSNotification *)nofication {
//    
//    UITextField *textField = nofication.object;
//    NSString *text = [textField text];
//    
//    NSLog(@"%@",text);
//    
//}

- (void)changeAction:(UITextField *)textField {
    
    NSString *text = [textField text];
    
    //1.定义谓词
    //[c] 忽略大小写
    NSString *t = [NSString stringWithFormat:@"self like [c]'*%@*'",text];
    NSPredicate *predicate = [NSPredicate predicateWithFormat:t];
    
    //2.使用谓词过滤
    self.filteData = [_data filteredArrayUsingPredicate:predicate];
    
    //3.显示
    [self.tableView reloadData];
}


#pragma mark - UITableView dataSource
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.filteData.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    static NSString *identify = @"Cell";
    
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:identify];
    
    if (cell == nil) {
        cell = [[[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:identify] autorelease];
    }
    
    cell.textLabel.text = [self.filteData objectAtIndex:indexPath.row];
    
    return cell;
}

@end
